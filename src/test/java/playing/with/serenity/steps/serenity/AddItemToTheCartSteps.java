package playing.with.serenity.steps.serenity;

import net.thucydides.core.annotations.Step;
import playing.with.serenity.pages.CartPage;
import playing.with.serenity.pages.InventoryPage;
import playing.with.serenity.pages.MenuBar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddItemToTheCartSteps {

    InventoryPage inventoryPage;
    MenuBar menuBar;
    CartPage cartPage;

    String itemName;

    @Step
    public void adds_item_to_the_cart(String itemName) {
        this.itemName = itemName;
        inventoryPage.add_item(itemName);
    }

    @Step
    public void should_see_the_product_added_to_the_cart() {
        menuBar.go_to_shopping_cart();
        assertThat(cartPage.return_products_list().size(), equalTo(1));
        assertThat(cartPage.return_products_list().stream().findFirst().get().get("name"), equalTo(itemName));
    }
}
