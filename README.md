# OSGi Starter
Starter files for osgi based projects.

## Features
* Lightweight workspace setup
* Multiple simple bundles
* Build standalone application

## Requirements
Only [JDK 17+](https://adoptium.net/temurin/releases/) is required.  
For development an IDE ([intellij](https://www.jetbrains.com/idea/download/) recommended) should get installed.

## Usage
* Compile bundles: `./gradlew jar`
  * Output: _<BUNDLE_DIRECTORY>/generated/<BUNDLE_NAME>.jar_
* Export fat-jar: `./gradlew export.my`
  * Output: _dev.youka.my.application/generated/distributions/executable/my.jar_
* Run application: `./gradlew run.my`
  * Runs in terminal, stop by _CTRL + C_
* Run tests: `./gradlew test`

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