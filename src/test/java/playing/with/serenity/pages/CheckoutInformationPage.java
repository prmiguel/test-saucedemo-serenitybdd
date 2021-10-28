package playing.with.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.saucedemo.com/checkout-step-one.html")
public class CheckoutInformationPage extends PageObject {

    @FindBy(css = "#first-name")
    private WebElementFacade firstNameInput;

    @FindBy(css = "#last-name")
    private WebElementFacade lastNameInput;

    @FindBy(css = "#postal-code")
    private WebElementFacade zipPostalCodeInput;

    @FindBy(css = "#continue")
    private WebElementFacade continueButton;

    public void provide_checkout_information(String fistName, String lastName, String zipPostalCode) {
        firstNameInput.type(fistName);
        lastNameInput.type(lastName);
        zipPostalCodeInput.type(zipPostalCode);
    }

    public void continue_with_checkout_process() {
        continueButton.click();
    }
}
