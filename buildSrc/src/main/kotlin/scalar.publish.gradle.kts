import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm

plugins {
    id("com.vanniktech.maven.publish")
    id("org.jetbrains.dokka-javadoc")
}

dokka {
    dokkaGeneratorIsolation.set(
        ProcessIsolation {
            maxHeapSize.set("8g")
        }
    )
}

mavenPublishing {
    configure(
        KotlinJvm(
            javadocJar = JavadocJar.Dokka("dokkaGeneratePublicationJavadoc"),
            sourcesJar = true,
        )
    )
    publishToMavenCentral(automaticRelease = true)
    signAllPublications()
    coordinates(project.group.toString(), project.name, project.version.toString())
    pom {
        name.set("Scalar SDK")
        description.set("API for managing Scalar platform resources.")
        url.set("https://github.com/scalar/scalar-java")
        licenses {
            license {
                name.set("Apache-2.0")
                url.set("https://github.com/scalar/scalar-java/blob/HEAD/LICENSE")
            }
        }
        developers {
            developer {
                id.set("scalar")
                name.set("Scalar")
                url.set("https://github.com/scalar/scalar-java")
            }
        }
        scm {
            url.set("https://github.com/scalar/scalar-java")
            connection.set("scm:git:https://github.com/scalar/scalar-java.git")
            developerConnection.set("scm:git:ssh://git@github.com/scalar/scalar-java.git")
        }
    }
}

tasks.withType<Zip>().configureEach {
    isZip64 = true
}

tasks.named<org.gradle.jvm.tasks.Jar>("dokkaJavadocJar") {
    exclude("dokka-configuration.json")
}
