# SeleniumWebDriver-Automation

#Highlights
	*MAVEN Project
	*PageObject Concepts
	*TestNG Framework
	*Supports Chrome and Firefox Drivers

#mvn project
pom.xml

Example - mvn clean test

#Classes

TestBase: Launches driver as per data.properties file, logout and quit driver

TestUtility - contains
	* Wait for Elements to appear
	* Read data.properties file

DriverClass - Returns driver depending on values in data.properties file

data.properties - Contains login, URL's details and ChromeDriver path

#Folders
drivers - Contains Chrome driver

data - contains data.properties file



