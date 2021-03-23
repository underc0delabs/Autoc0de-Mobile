# Autoc0de: Automation Framework - Mobile 
## _Open source tests automation framework for mobile devices_



[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://github.com/Joel-Vitelli/Autoc0de-Mobile)

## Indice

In this README.MD we will see the following topics:

- What can we do with this Framework
- What technologies are incorporated (Technological Stak)
- Project architecture
- Tools needed to run it locally and Steps to run the Framework
- How to change the suite to be run

## What can we do with this Framework

- Add automated code reproducible through a virtual (or physical) mobile device (Android)
- Automate in BDD using ** Gherkin ** language
- Obtain at the end of each execution, three types of reports **(ExtentReport, ReportePFD, Cucumber Basic Report)**
- Use the framework's own functions to streamline repetitive tasks
- Execution ** sequential ** (Configurable to Parallel)

This framework is maked based on several technologies that are detailed in the next point. All open source

## Technological Stak

This Framework includes the following technologies:

- [Maven] - Java project management and construction tool
- [Java] - OO programming language.
- [Selenium] - Automation tool Web, Mobile, API, Desktop.
- [Appium] - Interface that allows us to connect to a Selenium server with a mobile device.
- [Cucumber] - Herramienta que nos permite generar scripts de prueba utilizando tests cases escritos en Gherkin **(Archivos.feature)**.
- [Gherkin] - Tool that allows us to generate tests scripts using tests cases written in Gherkin **(Files.feature)**.
- [Extent Report] - Intuitive reporter and very nice to look at.
- [TestNG] - Automation tool that will allow us to create Runners and use notations.
- [Android Studio AVD] - Necessary for creating virtual devices (Create Pixel 8 to run this suite).

**IDE recommended**
- [IntelliJ] - Excellent Ide for automation development

**Recommended plugins for IntelliJ**
- **Gherkin**
- **Cucumber for Java**


The technologies mentioned above are integrated into the framework through MAVEN in the **pom.xml** file. The versions are specified below:

| Technology | Maven version |Link Maven repo|
| ------ | ------ |------|
| Selenium-java | 3.141.59|https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java|
| TestNG maven | 7.4.0 |https://mvnrepository.com/artifact/org.testng/testng|
| Cucumber-java | 6.10.2 |https://mvnrepository.com/artifact/io.cucumber/cucumber-java|
| Cucumber-testng | 6.10.2 |https://mvnrepository.com/artifact/io.cucumber/cucumber-testng|
| Cucumber-core | 6.10.2 |https://mvnrepository.com/artifact/io.cucumber/cucumber-core|
| Appium Java-client | 7.5.0 |https://mvnrepository.com/artifact/io.appium/java-client|
| Extent Report Adapter | 2.7.0 |https://mvnrepository.com/artifact/com.aventstack/extentreports|

**Remember to keep these versions of Maven up to date as much as possible. If the project ever stops working, it could be because one of the versions found here has been deprecated / moved. However, it must be remembered that at the date this project was uploaded, all versions are the most current**

## Framework architecture

This Framework uses the automation pattern [Page Object] and is structured as follows.


```
.
│ .idea    
└── src
    ├── main
    │   ├── java
    │   ├── resources
    └── test
    │   ├── java   
    │   │   └── com.autoc0de
    │   │       ├── hooks  ------------------------------> Folder where our Hooks are stored            
    │   │       │   └── Hook.class ----------------------> Framework hook
    │   │       ├── pages -------------------------------> Folder where our Pages are stored
    │   │       │   └── ExamplePage.class ---------------> Example of a page
    │   │       ├── steps -------------------------------> Folder where our Pages are stored
    │   │       │   └── ExampleSteps.class --------------> Example of a step definition
    │   │       ├── utility -----------------------------> Folder with useful functions
    │   │       │   └── Utils.class ---------------------> File with useful functions
    │   │       └── tests -------------------------------> Folder with MasterPage and Runner of TestNG
    │   │           └── MasterPage.class ----------------> MasterPage with generic functions
    │   │           └── TestRunner.class ----------------> Runner of TestNG
    │   └── resources
    │       ├── apps ------------------------------------> Folder where we place our APK
    │       │   └── ExampleAPK.apk ----------------------> Mini APK to execute an example
    │       ├── features --------------------------------> Folder where out features files are stored
    │       │   └── Example.features --------------------> Example of a feature file
    │       ├── extent.properties -----------------------> Report properties
    │       ├── extent-config.xml -----------------------> Report config
    │       └── pdf-config1.yaml ------------------------> Report PDF properties
    ├── pom.xml -----------------------------------------> POM File of this framework
    └── testing.xml -------------------------------------> TestRunner config
```

<p align="center">
  <img src="img/structure.png"/>
</p>

This project is based on 3 levels:
* Page objects (They are all our pages that in this case, are in the folder ```pages```)
* Step definitions (They are all the definitions of our steps written in [Gherkin], in this case, in the folder ```steps```)
* Features (These are all our .features files written in [Gherkin], in this case, in the folder ```features```)



## Tools needed to run it locally and Steps to run the Framework

In the ```Technological Stack``` section, we will find links that will take us to the websites to download all the tools we need. However, when using maven, we only need to install:
* Maven 3.6.3
* Java
* JDK
* Appium desktop
* Virtual device (Android Studio AVD, Genexus, etc.)

1. Install Maven 3.6.3
2. Install Java and JDK
3. Expose Maven and Java in environment variables
4. Install Appium desktop
5. Install Android studio, and create a new virtual device Pixel 8
6. Inside the root path of the newly cloned project, open the console and execute the following maven command: ```mvn install```. This will download all the necessary dependencies found in the ```pom.xml``` file

Once we have everything we need installed, to run the project we have 2 options:
* Inside the project with an ide (IntelliJ for example), select the file ```TestRunner.class```, right click on it, option "Debug"
* Open console within the path of the newly cloned project and execute the following maven command ```mvn clean install tests```

At this time we should be running the automatic tests on our Pixel 8 virtual device

7. When the execution finishes, we go to the folder ```target / Reports``` where we will find the ExtentReport report called``` Autoc0de-Mobile-HTML.html``` and the PDF report called ```Autoc0de-Mobile-PDF.pdf```
8. Finally, if we wish, we execute the maven command ```mvn clean``` to delete the folder ```target``` and all its content



## How to change the sweep that is going to be executed

To change the scenario we want to run, we have to modify the ```@Tag``` of [Cucumber] in the file ```TestRunner``` and in the file ```Hook``` as indicated in the following images:

```File Hook.class```

<p align="center">
  <img src="img/tag1.png"/>
</p>

```File TestRunner.class```

<p align="center">
  <img src="img/tag2.png"/>
</p>

Remember that the ```@tag``` that we are going to replace has to be identical in both files, and it has to exist within the feature that we want to execute, for example:

```File Feature.feature```

<p align="center">
  <img src="img/tag3.png"/>
</p>

# Enjoy!

## Architect, creator and developer of the framework
```sd
    * Joel Vitelli
```
## Distributed by
```sd
    * Underc0de.org
```

## Contributing Developers
```sd    
```

   
   
   [Maven]: <https://maven.apache.org/download.cgi>
   [Java]: <https://www.oracle.com/java/technologies/javase-jdk15-downloads.html>
   [Selenium]: <https://www.selenium.dev/documentation/en/>
   [Appium]: <https://appium.io/>
   [Cucumber]: <https://cucumber.io/>
   [Gherkin]: <https://cucumber.io/docs/gherkin/reference/>
   [Extent Report]: <https://www.extentreports.com/> 
   [TestNG]: <https://testng.org/doc/documentation-main.html>
   [Android Studio AVD]: <https://developer.android.com/studio>
   [IntelliJ]: <https://www.jetbrains.com/idea/>
   [Page Object]: <https://www.tutorialselenium.com/2019/02/05/page-object-model-selenium-webdriver/>