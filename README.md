# Solvd Automation Testing Project using Carina framework

This project is a testing exercise. It is using the website `https://www.automationexercise.com`.
It uses Maven for dependency management.

## Prerequisites

This project requires JDK 21 or higher. Make sure you have the correct version installed and configured on your system.

## Goals

- Understand how custom java selenium frameworks could be easily migrated to carina
- Practice with automation tests for Android platform; learn how to set up and use emulators for automation writing and running.
- Practice with different contexts in mobile automation
- Practice with automation tests for iOS platform; learn how to set up and use simulator for automation writing and running.

## Project Structure

1. `com.solvd`: Contains the main classes for the web pages that are being tested. Each class represents a different page on the website and contains methods for interacting with the elements on that page.
2. `config.properties`: Contains the home page url of the page that is being tested and location of the chromedriver.
3. `com.solvd.test`: Contains the test classes. These classes use TestNG for structuring and running the tests.
4. `src/test/resources`: Contains the TestNG suite xml file for running the tests.

## Dependencies

This project uses the following dependencies:

- Carina Core: provides the fundamental components and features of the Carina framework, which includes support for WebDriver.
- Carina API: provides methods for sending HTTP requests and validating responses.
- TestNG: For structuring and running the tests.
- Maven: For managing the project's dependencies.
- SLF4J and Log4j: For logging.
- MyBatis: MyBatis is a persistence framework that automates the mapping between SQL databases and objects in Java.

## To-do

- [ ] Migrate the whole pure-selenium project to the carina-project
- [ ] Fix enterAccountInformation() to work correctly with dropdown menu
- [ ] Find out how to make common methods for tests
