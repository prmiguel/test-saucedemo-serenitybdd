package playing.with.serenity.steps.serenity;

import net.thucydides.core.annotations.Step;
import playing.with.serenity.pages.InventoryPage;
import playing.with.serenity.pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;

public class LoginSteps {

    LoginPage loginPage;
    InventoryPage inventoryPage;

    @Step
    public void is_the_login_page() {
        loginPage.open();
    }

    @Step
    public void enters_credentials(String username, String password) {
        loginPage.logs_in_with(username, password);
    }

    @Step
    public void enters_invalid_credentials(String username, String password) {
        loginPage.logs_in_with(username, password);
    }

    @Step
    public void should_see_the_error(String errorMessage) {
        assertThat(loginPage.getErrorMessage(), equalTo(errorMessage));
    }

    @Step
    public void should_see_the_products() {
        assertThat(inventoryPage.getDriver().getCurrentUrl(), endsWith("inventory.html"));
        assertThat(inventoryPage.get_page_title(), equalTo("PRODUCTS"));
    }

    @Step
    public void is_logged_in_with_credentials(String username, String password) {
        loginPage.open();
        loginPage.logs_in_with(username, password);
    }
}
