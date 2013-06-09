# gwt-hotdeployment

[![Build Status](https://buildhive.cloudbees.com/job/jbarop/job/gwt-hotdeployment/badge/icon)](https://buildhive.cloudbees.com/job/jbarop/job/gwt-hotdeployment/)


## Description

Are you working with server side code in GWT's Development Mode and it's internal Jetty? Bored of reloading/redeploying by hand when you did change something in server code? Annoyed when did forget to reload?

_gwt-hotdeployment_ enables automatic reloading of the web application context when compiled classes change.


## License

    Copyright 2013 Johannes Barop

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

          http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


## Usage

1. Add _gwt-hotdeployment_ as dependency to your Maven project:

    ```
    <dependency>
      <groupId>de.barop.gwt</groupId>
      <artifactId>gwt-hotdeployment</artifactId>
      <version>1.0</version>
      <scope>provided</scope>
    </dependency>
    ```

2. Set _gwt-hotdeployment_'s customized Jetty as server launcher

    ```
    <plugin>
      <groupId>org.codehaus.mojo</groupId>
      <artifactId>gwt-maven-plugin</artifactId>
      <configuration>
        <-- ... -->
        <server>de.barop.gwt.HotDeploymentJettyLauncher</server>
      </configuration>
    </plugin>
    ```

3. Have fun

    Don't forget that server side code has to be compiled. You may
    want to set up your develop environment to do so automaticly.


## Demo

The repository contains a demo application ``gwt-hotdeployment-demo`` with which you can play around.
