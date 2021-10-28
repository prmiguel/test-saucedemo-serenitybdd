package playing.with.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject {

    @FindBy(css = "#user-name")
    private WebElementFacade usernameInput;

    @FindBy(css = "#password")
    private WebElementFacade passwordInput;

    @FindBy(css = "#login-button")
    private WebElementFacade loginButton;

    @FindBy(css = "div.error-message-container.error")
    private WebElementFacade errorLabel;

    @WhenPageOpens
    public void waitUntilPageLoaded() {
        element(loginButton).waitUntilVisible();
    }


    public void logs_in_with(String username, String password) {
        usernameInput.type(username);
        passwordInput.type(password);
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorLabel.getText();
    }

    public boolean isLoginVisible() {
        return loginButton.isVisible();
    }
}
