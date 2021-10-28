package playing.with.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.saucedemo.com/checkout-step-two.html")
public class CheckoutOverviewPage extends PageObject {

    @FindBy(css = ".summary_total_label")
    private WebElementFacade totalLabel;

    @FindBy(css = "#finish")
    private WebElementFacade finishButton;

    public void finish_checkout_process() {
        finishButton.click();
    }

    public String getTotal() {
        return totalLabel.getText();
    }
}
