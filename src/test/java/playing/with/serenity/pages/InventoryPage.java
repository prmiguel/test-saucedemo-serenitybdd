package playing.with.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@DefaultUrl("https://www.saucedemo.com/inventory.html")
public class InventoryPage extends PageObject {

    @FindBy(css = "select.product_sort_container")
    private WebElementFacade productsSortingDropdown;

    @FindBy(css = "div.inventory_item")
    private List<WebElementFacade> inventoryItemsCard;

    @FindBy(css = ".title")
    private WebElementFacade titleLabel;

    public void sort_products_by(String option) {
        productsSortingDropdown.selectByVisibleText(option);
    }

    public void add_item(String itemName) {
        inventoryItemsCard.stream()
                .filter(item -> item.thenFind(".inventory_item_name").getText().equals(itemName))
                .findFirst().get().thenFind(".btn_inventory[id^='add-to-cart']").click();

    }

    public List<Map<String, String>> return_products_list() {
        return inventoryItemsCard.stream()
                .map(item -> new HashMap<String, String>() {{
                    put("name", item.thenFind(".inventory_item_name").getText());
                    put("description", item.thenFind(".inventory_item_desc").getText());
                    put("price", item.thenFind(".inventory_item_price").getText());
                }})
                .collect(Collectors.toList());
    }

    public String get_page_title() {
        return titleLabel.getText();
    }
}
