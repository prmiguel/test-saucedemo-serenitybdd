package playing.with.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPage extends PageObject {

    @FindBy(css = "#checkout")
    private WebElementFacade checkoutButton;

    @FindBy(css = "div.cart_item")
    private List<WebElementFacade> cartItemsCard;

    public List<Map<String, String>> return_products_list() {
        return cartItemsCard.stream()
                .map(item -> new HashMap<String, String>() {{
                    put("name", item.thenFind(".inventory_item_name").getText());
                    put("description", item.thenFind(".inventory_item_desc").getText());
                    put("price", item.thenFind(".inventory_item_price").getText());
                }})
                .collect(Collectors.toList());
    }

    public void start_checkout_process() {
        checkoutButton.click();
    }
}
