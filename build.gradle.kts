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
        compileOnly("org.projectlombok:lombok:1.18.24")?.apply { annotationProcessor(this) }
        // Simplify bean-to-bean mapping
        compileOnly("org.mapstruct:mapstruct:1.5.3.Final")?.apply { annotationProcessor("$group:mapstruct-processor:$version") }
    }

    // Enable JUnit5 testing
    tasks {
        withType(Test::class.java) {
            useJUnitPlatform()
        }
    }
}