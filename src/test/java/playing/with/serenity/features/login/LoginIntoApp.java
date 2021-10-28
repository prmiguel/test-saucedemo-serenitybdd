package playing.with.serenity.features.login;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import playing.with.serenity.steps.serenity.LoginSteps;

@RunWith(SerenityRunner.class)
public class LoginIntoApp {

    @Managed
    public WebDriver webdriver;

    @Steps
    public LoginSteps anna;

    @Test
    public void login_into_app_with_valid_credentials_should_display_the_products() {
        anna.is_the_login_page();
        anna.enters_credentials("standard_user", "secret_sauce");
        anna.should_see_the_products();
    }

    @Test
    public void login_into_app_with_invalid_credentials_should_display_an_error() {
        anna.is_the_login_page();
        anna.enters_invalid_credentials("standard_user", "?????????");
        anna.should_see_the_error("Epic sadface: Username and password do not match any user in this service");

    }
} 