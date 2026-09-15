plugins {
    id("scalar.kotlin")
}

repositories {
    // R8 is published to Google's Maven repository only; the convention plugin adds Maven Central.
    google()
}

// The shrinkers run as plain command-line tools out of their own configurations rather than through
// `buildscript { dependencies { classpath(...) } }` and a shrinker Gradle plugin. A buildscript
// classpath is resolved every time this project is *configured* — that is, on every build of the
// SDK, including ones that shrink nothing — while a project configuration is resolved only when a
// task that reads it runs.
val proguardTool: Configuration by configurations.creating
val r8Tool: Configuration by configurations.creating

dependencies {
    testImplementation(project(":scalar-java"))
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")

    proguardTool("com.guardsquare:proguard-base:7.9.1")
    r8Tool("com.android.tools:r8:9.4.14")
}

val mainClassName = "com.scalar.proguard.ProGuardCompatibilityTest"
// The consumer keep rules exactly as they are published inside the `-core` jar, plus the entry
// points this test needs. Shrinking under anything else would prove nothing about a real consumer.
val keepRules =
    files(
        "test.pro",
        "../scalar-java-core/src/main/resources/META-INF/proguard/scalar-java-core.pro",
    )
val shrinkInput = layout.buildDirectory.file("libs/${project.name}-shrink-input.jar").get().asFile
val proguardOutput = layout.buildDirectory.file("libs/${project.name}-proguard.jar").get().asFile
val r8Output = layout.buildDirectory.file("libs/${project.name}-r8.jar").get().asFile

// The build's declared toolchain, not whatever JVM happens to be running Gradle. `java { toolchain
// }`
// reaches `JavaCompile`, `Test`, and `Javadoc` — never `JavaExec` — so without this the four tasks
// below launch on the daemon's JDK while the classes they run were compiled at the toolchain's
// release. A contributor whose `JAVA_HOME` is older than the toolchain then gets a passing
// `./gradlew test` and an `UnsupportedClassVersionError` out of `./gradlew testProGuard`. The same
// JDK is what the shrinkers must read the platform classes from, so both read it from here.
//
// The `get()` resolves the toolchain while this project is *configured*, because the shrinker
// arguments below are built at configuration time and need the path as a string. That makes the
// toolchain a requirement of configuring this module at all rather than only of compiling it — the
// one place this module is less lazy than the rest of the build.
val shrinkerLauncher = javaToolchains.launcherFor(java.toolchain)
val javaHome: String = shrinkerLauncher.get().metadata.installationPath.asFile.path

/** The test classes and every runtime dependency in one jar, which is what a shrinker takes in. */
val shrinkInputJar by
    tasks.registering(Jar::class) {
        group = "verification"
        description = "Packs the test classes and their runtime classpath into one shrinkable jar."
        // The repack reads the resolved classpath while it runs, which the configuration cache
        // cannot record. Only the shrinker tasks depend on this, so an ordinary build keeps its
        // cached configuration.
        notCompatibleWithConfigurationCache("Repacks the resolved test runtime classpath.")
        archiveFileName.set(shrinkInput.name)
        destinationDirectory.set(shrinkInput.parentFile)
        // Signature files no longer describe a repacked jar, and stacked module descriptors are
        // ambiguous once several modules are merged into one.
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        exclude(
            "META-INF/*.SF",
            "META-INF/*.DSA",
            "META-INF/*.RSA",
            "META-INF/versions/**",
            "module-info.class",
        )
        from(sourceSets.test.get().output)
        dependsOn(configurations.testRuntimeClasspath)
        from(
            provider {
                configurations.testRuntimeClasspath.get().map {
                    if (it.isDirectory) it else zipTree(it)
                }
            }
        )
    }

val proguardJar by
    tasks.registering(JavaExec::class) {
        group = "verification"
        description = "Shrinks the SDK with ProGuard under the keep rules consumers are given."
        dependsOn(shrinkInputJar)
        javaLauncher.set(shrinkerLauncher)
        mainClass.set("proguard.ProGuard")
        classpath = proguardTool
        args =
            listOf(
                "-injars",
                shrinkInput.path,
                "-outjars",
                proguardOutput.path,
                "-libraryjars",
                "$javaHome/jmods/java.base.jmod(!**.jar;!module-info.class)",
                "-printmapping",
                layout.buildDirectory.file("proguard-mapping.txt").get().asFile.path,
            ) + keepRules.files.flatMap { listOf("-include", it.path) }
    }

val testProGuard by
    tasks.registering(JavaExec::class) {
        group = "verification"
        description = "Runs the compatibility test out of the ProGuard-shrunk jar."
        dependsOn(proguardJar)
        javaLauncher.set(shrinkerLauncher)
        mainClass.set(mainClassName)
        classpath = files(proguardOutput)
    }

val r8Jar by
    tasks.registering(JavaExec::class) {
        group = "verification"
        description = "Shrinks the SDK with R8 under the keep rules consumers are given."
        dependsOn(shrinkInputJar)
        javaLauncher.set(shrinkerLauncher)
        mainClass.set("com.android.tools.r8.R8")
        classpath = r8Tool
        args =
            listOf(
                "--release",
                "--classfile",
                "--output",
                r8Output.path,
                "--lib",
                javaHome,
                "--pg-map-output",
                layout.buildDirectory.file("r8-mapping.txt").get().asFile.path,
                // Third-party generic signatures R8 cannot validate are reported per class and bury
                // any real diagnostic; they are informational and do not affect the output.
                "--map-diagnostics",
                "info",
                "none",
            ) + keepRules.files.flatMap { listOf("--pg-conf", it.path) } + listOf(shrinkInput.path)
    }

val testR8 by
    tasks.registering(JavaExec::class) {
        group = "verification"
        description = "Runs the compatibility test out of the R8-shrunk jar."
        dependsOn(r8Jar)
        javaLauncher.set(shrinkerLauncher)
        mainClass.set(mainClassName)
        classpath = files(r8Output)
    }
