# gwt-hotdeployment

[![Build Status](https://buildhive.cloudbees.com/job/jbarop/job/gwt-hotdeployment/badge/icon)](https://buildhive.cloudbees.com/job/jbarop/job/gwt-hotdeployment/)


## Description

Enables automatic reloading of server classes in GWT's internal Jetty


## License

    Copyright 2012 Johannes Barop

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

          http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


## Usage (with Maven)

1. Add _gwt-hotdeployment_ as dependency to your Maven project:

    ```
    <dependency>
      <groupId>de.barop.gwt</groupId>
      <artifactId>gwt-hotdeployment</artifactId>
      <version>0.1-SNAPSHOT</version>
    </dependency>
    ```

2. Set _gwt-hotdeployment_'s customized Jetty as server launcher

    ```
    <plugin>
      <groupId>org.codehaus.mojo</groupId>
      <artifactId>gwt-maven-plugin</artifactId>
      <version>${gwt.version}</version>
      <configuration>
        <-- ... -->
        <server>de.barop.gwt.HotDeploymentJettyLauncher</server>
      </configuration>
    </plugin>
    ```

3. Have fun
