# osgi-starter
Starter files for osgi based projects.

## Features
* Lightweight workspace setup
* Example for web endpoints and unit tests
* Supports popular annotation processors
* Build standalone applications

## Requirements
Only [JDK 17+](https://adoptium.net/temurin/releases/) is required.  
For development an IDE ([intellij](https://www.jetbrains.com/idea/download/) or [eclipse](https://www.eclipse.org/downloads/packages/)) should get installed.

## Usage
* Defined application bundle (see `io.youka.osgi.application` bundle):
  * **application-web**:
    * Export: `./gradlew export.application-web`
    * Run: `./gradlew run.application-web`
    * Interaction: _the jetty web server listens on http://localhost:8181 and provides routes by servlet implementations (see `io.youka.osgi.hello-servlet.provider`)_
* Run unit tests: `./gradlew test`
* Advanced bundle resolution:
  * Add [-runrequires](https://bnd.bndtools.org/instructions/runrequires.html) to _*.bndrun_ files
  * Call `./gradlew resolve`
  * `-runbundles` gets updated by deep search of requirements

## Next steps
* Add logging (+ backend configuration)
* Add webconsole (+ plugins)
* Provide service configurations
* Enable security (framework, interfaces)
* Add integration tests (OSGi tests which run bundles)
* Automate releases (artifact upload, dockerfile, ci pipeline)
* Improve quality assurance (linter, code coverage, monitoring)
* ...

## References
* OSGi framework: [Apache Felix](https://felix.apache.org/documentation/downloads.html)
  * Subprojects: [felix-dev](https://github.com/apache/felix-dev)
* Management CLI: [bndtools](https://bnd.bndtools.org/chapters/120-install.html)
* IDE plugins:
  * [IntelliJ](https://plugins.jetbrains.com/plugin/10639-amdatu)
  * [Eclipse](https://marketplace.eclipse.org/content/bndtools-osgi-development-tool)
* OpenAPI generator: [openapi-generator-gradle-plugin](https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-gradle-plugin)
* Guides:
  * [bndtools - Guided tour](https://bnd.bndtools.org/chapters/123-tour-workspace.html)
  * [bndtools - Video tour](https://bndtools.org/workspace.html)
  * [aQute - Example repository](https://github.com/aQute-os/com.example)
  * [OSGi - Compendium (v8)](https://docs.osgi.org/specification/osgi.cmpn/8.0.0/)
  * [OSGi - Test examples](https://github.com/osgi/osgi-test/tree/main/examples)
  * [Apache Felix - Tutorials](https://felix.apache.org/documentation/tutorials-examples-and-presentations.html)