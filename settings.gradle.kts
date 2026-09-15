rootProject.name = "scalar-java-root"

val projectNames =
    rootDir
        .listFiles()
        ?.asSequence()
        .orEmpty()
        .filter { file ->
            file.isDirectory &&
                file.name != "buildSrc" &&
                file.name.startsWith("scalar") &&
                file.listFiles()?.asSequence().orEmpty().any { it.name == "build.gradle.kts" }
        }
        .map { it.name }
        .toList()

println("projects: $projectNames")

projectNames.forEach { include(it) }
