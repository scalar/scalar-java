import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("scalar.java")
    kotlin("jvm")
}

kotlin {
    jvmToolchain(21)

    compilerOptions {
        freeCompilerArgs =
            listOf(
                "-Xjvm-default=all",
                // Generated sources reference their own deprecated members, so a deprecation
                // warning here is expected output rather than something a consumer can act on.
                "-nowarn",
            )
        jvmTarget.set(JvmTarget.JVM_1_8)
        languageVersion.set(KotlinVersion.KOTLIN_1_8)
        apiVersion.set(KotlinVersion.KOTLIN_1_8)
        coreLibrariesVersion = "1.8.0"
    }
}

// The generated tests compile against the JDK the build runs on, not the floor the library
// publishes, so only the library sources are held to the floor class library.
tasks.named<KotlinCompile>("compileKotlin") {
    compilerOptions.freeCompilerArgs.add("-Xjdk-release=1.8")
}

// Kotlin refuses to compile a source set whose Java and Kotlin halves disagree about the JVM
// target, so lifting the test sources on the javac side has to lift them here as well.
tasks.named<KotlinCompile>("compileTestKotlin") {
    compilerOptions.jvmTarget.set(JvmTarget.JVM_21)
}
