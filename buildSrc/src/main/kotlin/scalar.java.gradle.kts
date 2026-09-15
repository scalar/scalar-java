import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

java {
    toolchain { languageVersion.set(JavaLanguageVersion.of(21)) }

    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8

    withSourcesJar()
}

tasks.named<JavaCompile>("compileJava") {
    options.compilerArgs.add("-Werror")
    options.release.set(8)
}

// The generated tests target the JDK the build runs on, not the floor the library publishes.
// `options.release` outranks the `sourceCompatibility` above, so this lifts the whole pin.
tasks.named<JavaCompile>("compileTestJava") {
    options.release.set(21)
}

tasks.named<Jar>("jar") {
    manifest {
        attributes(
            mapOf(
                "Implementation-Title" to project.name,
                "Implementation-Version" to project.version,
            )
        )
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()

    // Run tests in parallel to some degree.
    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).coerceAtLeast(1)
    forkEvery = 100

    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
    }
}
