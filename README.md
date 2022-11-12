# osgi-starter
Starter files for osgi based projects.

## Features
* Multiple simple bundles
* Lightweight workspace setup
* Examples for shell commands, web endpoints, custom services and unit tests
* Supports popular annotation processors
* Build standalone applications

## Requirements
Only [JDK 17+](https://adoptium.net/temurin/releases/) is required.  
For development an IDE ([intellij](https://www.jetbrains.com/idea/download/) or [eclipse](https://www.eclipse.org/downloads/packages/)) + osgi plugin should get installed.

## Usage
* Build bundles + application jars (includes testing): `./gradlew build`
* Run application:
  * With gogo shell: `java -jar io.youka.osgi.application/build/application-shell.bndrun-1.0.0-SNAPSHOT.jar`  
    _(gogo shell and gradle task are in conflict / cannot run simultaneously)_
  * With web server: `./gradlew run.application-web`
  * With services only: `./gradlew run.application-service`
* User interaction:
  * Shell: the shell launches in console and shows options on input `help`.
  * Web: the jetty web server listens on http://localhost:8181 and provides routes by servlet implementations.
  * Service: see console output (nothing more happens).

## Next steps
* Add logging (+ backend configuration)
* Add webconsole (+ plugins)
* Provide service configurations (+ configadmin)
* Migrate servlet -> jax-rs (+ json serialization)
* Enable security (framework, interfaces)
* Automate releases (artifact upload, dockerfile, ci pipeline)
* Improve quality assurance (linter, code coverage, monitoring)
* ...

## References
* OSGi framework: [Apache Felix](https://felix.apache.org/documentation/downloads.html)
  * Subprojects: [felix-dev](https://github.com/apache/felix-dev)
* Management CLI: [bndtools](https://bnd.bndtools.org/chapters/120-install.html)
* IDE plugins:
  * [IntelliJ](https://plugins.jetbrains.com/plugin/1816-osgi)
  * [Eclipse](https://marketplace.eclipse.org/content/bndtools-osgi-development-tool)
* Guides:
  * [bndtools - Guided tour](https://bnd.bndtools.org/chapters/123-tour-workspace.html)
  * [bndtools - Video tour](https://bndtools.org/workspace.html)
  * [aQute - Example repository](https://github.com/aQute-os/com.example)
  * [OSGi - Compendium (v8)](https://docs.osgi.org/specification/osgi.cmpn/8.0.0/)
  * [Apache Felix - Tutorials](https://felix.apache.org/documentation/tutorials-examples-and-presentations.html)
  * [OSGi - Test examples](https://github.com/osgi/osgi-test/tree/main/examples)