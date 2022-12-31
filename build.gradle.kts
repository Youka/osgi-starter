// Project meta information
group = "io.youka"
version = "1.0.0-SNAPSHOT"


// Import api to create resources for subprojects
plugins {
    java
    id("org.openapi.generator") version "6.2.1"
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

    // Enable JUnit5 testing
    tasks {
        withType(Test::class.java) {
            useJUnitPlatform()
        }
    }

    // Enable OpenAPI generator
    projectDir.resolve("src/openapi.yaml").takeIf(File::exists)?.let { file ->
        apply(plugin = "org.openapi.generator")
        openApiValidate {
            inputSpec.set(file.path)
        }
        openApiGenerate {
            inputSpec.set(file.path)
            generatorName.set(org.openapitools.codegen.languages.KotlinServerCodegen.Constants.JAXRS_SPEC)
            outputDir.set(buildDir.resolve("openapi").path)
            apiPackage.set("$name.api")
            modelPackage.set("$name.model")
            configOptions.set(mapOf(
                "dateLibrary" to "java8",
                "generatePom" to "false",
            ))
        }
    }
}

// Disable OpenAPI generator in root project (still triggers subprojects)
tasks {
    openApiValidate.configure { enabled = false }
    openApiGenerate.configure { enabled = false }
}