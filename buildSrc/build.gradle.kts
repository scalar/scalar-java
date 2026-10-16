plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.9.20"
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.20")
    implementation("com.vanniktech.maven.publish:com.vanniktech.maven.publish.gradle.plugin:0.34.0")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:2.0.0")
}
