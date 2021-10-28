package playing.with.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class MenuBar extends PageObject {

    @FindBy(css = "#react-burger-menu-btn")
    private WebElementFacade menuButton;

    @FindBy(css = "#logout_sidebar_link")
    private WebElementFacade logoutOption;

    @FindBy(css = "a.shopping_cart_link")
    private WebElementFacade shoppingCartLink;

    public void open_menu() {
        menuButton.click();
    }

    public void logs_out() {
        logoutOption.click();
    }

    public void go_to_shopping_cart() {
        shoppingCartLink.click();
    }
}
