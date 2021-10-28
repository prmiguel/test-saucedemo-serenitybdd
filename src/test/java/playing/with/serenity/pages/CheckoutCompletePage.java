package playing.with.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.saucedemo.com/checkout-complete.html")
public class CheckoutCompletePage extends PageObject {

    @FindBy(css = ".complete-header")
    private WebElementFacade orderTitle;

    @FindBy(css = ".complete-text")
    private WebElementFacade orderDescription;

    public String getOrderTitle() {
        return orderTitle.getText();
    }

    public String getOrderDescription() {
        return orderDescription.getText();
    }
}
