<!--
    Licensed to the Apache Software Foundation (ASF) under one
    or more contributor license agreements.  See the NOTICE file
    distributed with this work for additional information
    regarding copyright ownership.  The ASF licenses this file
    to you under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.
-->

# Experimental

## Goal: Get TestNG, Java9+ (JPMS), Maven, Eclipse working with non-module dependencies.
* This toy is just to get TestNG to work. If this works, I should be able to extend to other required dependencies.

* I would like to make sure this works from both the command-line and from Eclipse as then I will understand what is going on.

## [Using Java Modularity (JPMS) in Tests](https://maven.apache.org/surefire/maven-surefire-plugin/examples/jpms.html)

The properties and dependencies in the *Examples Using TestNG* are duplicated almost exactly in the *pom.xml*.

The Example instructs the user to create module-info.java files in both *src/main/java* and in *src/test/java*.
However this creates a duplicate error:

>The project was not built due to "Build path contains duplicate entry: 'module-info.java' for project 'datasketches-panama'".

### Describe Module of TestNG:

```
~ > jar --file ./.m2/repository/org/testng/testng/7.3.0/testng-7.3.0.jar --describe-module
No module descriptor found. Derived automatic module.

org.testng@7.3.0 automatic
requires java.base mandated
provides org.testng.xml.ISuiteParser with org.testng.internal.YamlParser
contains org.testng
contains org.testng.annotations
contains org.testng.asserts
contains org.testng.collections
contains org.testng.internal
contains org.testng.internal.annotations
contains org.testng.internal.ant
contains org.testng.internal.collections
contains org.testng.internal.invokers
contains org.testng.internal.junit
contains org.testng.internal.reflect
contains org.testng.internal.thread
contains org.testng.internal.thread.graph
contains org.testng.junit
contains org.testng.log
contains org.testng.log4testng
contains org.testng.mustache
contains org.testng.reporters
contains org.testng.reporters.jq
contains org.testng.reporters.util
contains org.testng.thread
contains org.testng.util
contains org.testng.xml
contains org.testng.xml.internal
```

## From the command line works:
(base) experimental $ pwd
/Users/lrhodes/dev/git/Oracle/experimental

(base) experimental $ find src/main/java/ -name "*.java" > sources.txt

(base) experimental $ javac -d bin @sources.txt
warning: using incubating module(s): jdk.incubator.foreign
1 warning

(base) experimental $ java --module-path bin -m org.apache.datasketches.panama/org.apache.datasketches.panama.Play
WARNING: Using incubator modules: jdk.incubator.foreign
140607243978064



## Notes:
* The pom.xml is a copy paste from datasketches-java but the only dependency is TestNG and its dependencies, otherwise harmless.
