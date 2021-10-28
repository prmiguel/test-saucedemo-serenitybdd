package playing.with.serenity;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import playing.with.serenity.steps.serenity.LoginSteps;

public class BaseTests {

    @Managed
    public WebDriver webdriver;

    @Steps
    public LoginSteps user;

    @Before
    public void login() {
        user.is_logged_in_with_credentials("standard_user", "secret_sauce");
    }
}
