# osgi-starter
Starter files for osgi based projects.

## Features
* Multiple simple bundles
* Lightweight workspace setup
* Examples for shell commands and web endpoints
* Supports popular annotation processors
* Build standalone applications

## Requirements
Only [JDK 17+](https://adoptium.net/temurin/releases/) is required.  
For development an IDE ([intellij](https://www.jetbrains.com/idea/download/) or [eclipse](https://www.eclipse.org/downloads/packages/)) + osgi plugin should get installed.

## Usage
* Build bundles + application jars: `./gradlew build`
* Run application:
  * With gogo shell: `java -jar io.youka.osgi.application/build/application-shell.bndrun-1.0.0-SNAPSHOT.jar`
  * With web server: `java -jar io.youka.osgi.application/build/application-web.bndrun-1.0.0-SNAPSHOT.jar`
* User interaction:
  * Shell: the shell launches in console and shows options on input `help`.
  * Web: the jetty web server listens on http://localhost:8181 and provides routes by servlet implementations.

## References
* OSGi framework: [Apache Felix](https://felix.apache.org/documentation/downloads.html)
  * Subprojects: [felix-dev](https://github.com/apache/felix-dev)
* Management CLI: [bndtools](https://bnd.bndtools.org/chapters/120-install.html)
* IDE plugins:
  * [IntelliJ](https://plugins.jetbrains.com/plugin/1816-osgi)
  * [Eclipse](https://marketplace.eclipse.org/content/bndtools-osgi-development-tool)
* Guides:
  * [Guided tour](https://bnd.bndtools.org/chapters/123-tour-workspace.html)
  * [Video tour](https://bndtools.org/workspace.html)
  * [Example repository](https://github.com/aQute-os/com.example)