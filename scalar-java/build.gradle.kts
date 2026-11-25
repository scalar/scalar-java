plugins {
    id("scalar.kotlin")
    id("scalar.publish")
}

dependencies {
    api(project(":scalar-java-client-okhttp"))

    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
}

tasks.named<Test>("test") {
    val smokeReportDir = providers.environmentVariable("SCALAR_SMOKE_REPORT_DIR")
    val smokeBaseUrl = providers.environmentVariable("TEST_API_BASE_URL")
    // The smoke tests skip unless TEST_API_BASE_URL is set and record each case into
    // SCALAR_SMOKE_REPORT_DIR. A cached or up-to-date result would skip execution and leave a smoke
    // run with no records (or restore a run where every case skipped) even though Gradle exits
    // cleanly, so either variable keeps this task out of both. Blank reads as unset, as the suite
    // reads it.
    outputs.upToDateWhen {
        smokeReportDir.orNull.isNullOrBlank() && smokeBaseUrl.orNull.isNullOrBlank()
    }
    outputs.cacheIf { smokeReportDir.orNull.isNullOrBlank() && smokeBaseUrl.orNull.isNullOrBlank() }

    // One test JVM for the whole suite: the convention plugin forks a fresh JVM every 100 test
    // classes, which on a large document would run the suite as sequential batches, each draining
    // to its slowest case before the next starts.
    maxParallelForks = 1
    forkEvery = 0

    // The smoke test classes opt into concurrent execution (`@Execution(CONCURRENT)`); every
    // other test keeps running on one thread. That JVM runs at most
    // SCALAR_SMOKE_CONCURRENCY cases at once (32 by default).
    systemProperty("junit.jupiter.execution.parallel.enabled", "true")
    systemProperty("junit.jupiter.execution.parallel.mode.default", "same_thread")
    systemProperty("junit.jupiter.execution.parallel.config.strategy", "fixed")
    systemProperty(
        "junit.jupiter.execution.parallel.config.fixed.parallelism",
        providers.environmentVariable("SCALAR_SMOKE_CONCURRENCY").orNull?.toIntOrNull()?.takeIf {
            it > 0
        } ?: 32,
    )
}
