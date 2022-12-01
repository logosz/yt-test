# Youtube Music test for eFishery
**Description**
This repository was created to fulfill one of the hiring processes at eFishery.
This reposiroty was build under mac environment.

**Prerequisite**
- Maven 
- Java 1.8
- Selenium
- Cucumber
- webdriver
- Chrome browser

**Installation**
- Java installation https://www.java.com/en/download/help/mac_install.html
- Maven installation https://maven.apache.org/install.html
- Download latest chrome webdriver https://chromedriver.chromium.org/downloads
- Download latest chrome browser https://www.google.com/intl/en/chrome/
- Download maven dependency (Selenium,  Cucumber) https://mvnrepository.com/

**How to run the project**
- Clone project with command
```sh
gti clone https://github.com/logosz/yt-test.git
```
- Install all dependencies
```sh
mvn install -DskipTests
```
- Run the automation
```sh
mvn clean test -Dcucumber.filter.tags="@test_case_tag"
```

**Report**
- Refer to this file
```sh
src/test/resources/reports/cucumber.html
```



