package playing.with.serenity.steps.serenity;

import net.thucydides.core.annotations.Step;
import playing.with.serenity.pages.LoginPage;
import playing.with.serenity.pages.MenuBar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LogoutSteps {

    LoginPage loginPage;
    MenuBar menuBar;

    @Step
    public void is_logged_in_with_credentials(String username, String password) {
        loginPage.open();
        loginPage.logs_in_with(username, password);
    }

    @Step
    public void logs_out() {
        menuBar.open_menu();
        menuBar.logs_out();
    }

    @Step
    public void should_see_the_login() {
        assertThat(loginPage.isLoginVisible(), equalTo(true));
    }
}
