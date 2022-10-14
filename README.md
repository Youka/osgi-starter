# osgi-starter
Starter files for osgi based projects.

## Usage
* Build bundles + application jar: `./gradlew build`
* Run application: `java -jar io.youka.osgi.application/build/application.bndrun-1.0.0-SNAPSHOT.jar`

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