plugins {
    id("scalar.kotlin")
}

dependencies {
    api(project(":scalar-java-client-okhttp"))

    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
}

tasks.named<Test>("test") {
    val smokeReport = providers.environmentVariable("SCALAR_SMOKE_REPORT")
    // The generated smoke harness writes a per-run JSON report; cached test results would skip
    // execution and leave the smoke runner without a report even though Gradle exits cleanly.
    outputs.upToDateWhen { smokeReport.orNull == null }
    outputs.cacheIf { smokeReport.orNull == null }
}
