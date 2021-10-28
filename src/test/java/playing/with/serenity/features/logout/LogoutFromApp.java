package playing.with.serenity.features.logout;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import playing.with.serenity.steps.serenity.LogoutSteps;

@RunWith(SerenityRunner.class)
public class LogoutFromApp {

    @Managed
    public WebDriver webdriver;

    @Steps
    public LogoutSteps anna;

    @Test
    public void logout_should_get_out_the_user_from_the_app() {
        anna.is_logged_in_with_credentials("standard_user", "secret_sauce");
        anna.logs_out();
        anna.should_see_the_login();
    }
} 