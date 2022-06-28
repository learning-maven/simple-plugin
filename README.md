# A Simple Maven plugin

## Build

The plugin is tested with the neat [Maven Integration Test](https://github.com/khmarbaise/maven-it-extension) extension 
from [Karl Heinz Marbaise](https://github.com/khmarbaise).

To run all the integration tests, just run:

```shell
mvn
```

## Use on a project

Since this will likely never be released to Maven Central, the easiest way is to first run:

```shell
mvn install
```

Then, proceed to the project of your choice and run:

```shell
mvn io.github.learningmaven:simple-plugin-example:1.0-SNAPSHOT:ensure-neo4j
```

## Browse plugin site

First run:
```shell
mvn site
```

Then open `target/site/index.html`.