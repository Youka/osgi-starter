# osgi-starter
Starter files for osgi based projects.

## Features
* Multiple simple bundles
* Lightweight workspace setup
* Examples for custom services
* Build a standalone application

## Requirements
Only [JDK 17+](https://adoptium.net/temurin/releases/) is required.  
For development an IDE ([intellij](https://www.jetbrains.com/idea/download/) or [eclipse](https://www.eclipse.org/downloads/packages/)) should get installed.

## Usage
* Run the _service_ application (stored in bundle `io.youka.osgi.application`):
  * Export: `./gradlew export.application-service`
  * Run: `./gradlew run.application-service`
  * Interaction: _see console output (nothing more happens)_

## References
* OSGi framework: [Apache Felix](https://felix.apache.org/documentation/downloads.html)
  * Subprojects: [felix-dev](https://github.com/apache/felix-dev)
* Management CLI: [bndtools](https://bnd.bndtools.org/chapters/120-install.html)
* IDE plugins:
  * [IntelliJ](https://plugins.jetbrains.com/plugin/10639-amdatu)
  * [Eclipse](https://marketplace.eclipse.org/content/bndtools-osgi-development-tool)
* Guides:
  * [bndtools - Guided tour](https://bnd.bndtools.org/chapters/123-tour-workspace.html)
  * [bndtools - Video tour](https://bndtools.org/workspace.html)
  * [aQute - Example repository](https://github.com/aQute-os/com.example)
  * [OSGi - Compendium (v8)](https://docs.osgi.org/specification/osgi.cmpn/8.0.0/)
  * [OSGi - Test examples](https://github.com/osgi/osgi-test/tree/main/examples)
  * [Apache Felix - Tutorials](https://felix.apache.org/documentation/tutorials-examples-and-presentations.html)