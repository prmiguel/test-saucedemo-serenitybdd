# Automated Tests for `Sauce Demo` using `Serenity BDD`
Sauce Demo Web UI Tests


### Application Under Test (AUT)
[saucedemo](https://www.saucedemo.com/)

### Setup Test Development Environment

#### Requirements
Install the following software:
- AdoptJDK (at least version 1.8 or higher)
- IntelliJ IDE (CE or EE) - plugins (Lombok)
- Gradle (optional since the project contains its gradle wrapper)
- Chrome (latest version)
- Firefox (latest version)


### Test Execution
#### Command Line Test Execution
Run all tests:
```sh
cd test-saucedemo-serenitybdd
./gradlew clean test aggregate
```
> You can also set the following parameters:
> -Dsaucedemo.web.url="<your url>"
> -Dbrowser.name="<chrome or firefox>"
> -Dbrowser.headless="<true or false>"

Default values:
- saucedemo.web.url="https://www.saucedemo.com"
- browser.name="chrome"
- browser.headless="true"

<img src="./img/test-execution.webm" width="500" height="400" />

#### Docker Image Test Execution
```sh
cd test-saucedemo-serenitybdd
docker run -it -p 4444:4444 --rm -v ${PWD}:/code -u root prmiguel/selenium-standalone-chrome bash -c "cd /code; ./gradlew clean test aggregate"
```

### Report
Once the execution is clomplete, you can see the reports in `./reports` folder
- `.\target\site\serenity\index.html` contains the HTML report.
