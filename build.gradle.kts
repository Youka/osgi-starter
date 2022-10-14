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
        compileOnly("org.projectlombok:lombok:1.18.24")?.apply { annotationProcessor(this) }
    }
}