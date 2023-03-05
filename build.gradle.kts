import aQute.bnd.exporter.executable.ExecutableJarExporter
import aQute.bnd.gradle.Bndrun
import aQute.bnd.gradle.Export
import aQute.bnd.osgi.Constants

// Project meta information
group = "io.youka"
version = "1.0.0-SNAPSHOT"


// Import api to create resources for subprojects
plugins {
    java
}

// Extend build process for osgi bundles
subprojects {
    // Import abi for resources provided by the parent project
    apply(plugin = "java")

    // Add maven repository for gradle (bndtools uses MavenBndRepository plugin)
    repositories {
        mavenCentral()
    }

    // Extend java compilation by annotation processors
    dependencies {
        // Correct flaws of java programming language
        compileOnly("org.projectlombok:lombok:${properties["lombokVersion"]}")?.apply { annotationProcessor(this) }
        // Simplify bean-to-bean mapping
        compileOnly("org.mapstruct:mapstruct:${properties["mapstructVersion"]}")?.apply { annotationProcessor("$group:mapstruct-processor:$version") }
    }

    // Configure tasks
    tasks {
        // Enable JUnit5 testing
        withType(Test::class.java) {
            useJUnitPlatform()
        }

        // Disable buggy run.* tasks
        withType(Bndrun::class) {
            // Not removable/replaceable because of existing references
            enabled = false
            group = "disabled"
        }

        // Create new run tasks (based on exported jar)
        withType(Export::class) {
            if (exporter.get() == ExecutableJarExporter.EXECUTABLE_JAR) {
                doNotTrackState("Change detection on external bundles doesn't work!")
                val applicationName = name.substringAfter('.')
                create("exec.$applicationName", JavaExec::class) {
                    description = "Execute OSGi application '$applicationName' (including export)."
                    group = PublishingPlugin.PUBLISH_TASK_GROUP
                    classpath = files("${destinationDirectory.get()}${File.separatorChar}$applicationName${Constants.DEFAULT_JAR_EXTENSION}")
                    debug = System.getenv("exec.$applicationName.debug")?.isNotEmpty() ?: false
                }.dependsOn(this)
            }
        }
    }
}