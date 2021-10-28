package playing.with.serenity.steps.serenity;

import net.thucydides.core.annotations.Step;
import playing.with.serenity.pages.CartPage;
import playing.with.serenity.pages.InventoryPage;
import playing.with.serenity.pages.LoginPage;
import playing.with.serenity.pages.MenuBar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class AddItemsToTheCartSteps {

    LoginPage loginPage;
    InventoryPage inventoryPage;
    MenuBar menuBar;
    CartPage cartPage;

    String[] itemNames;

    @Step
    public void is_logged_in_with_credentials(String username, String password) {
        loginPage.open();
        loginPage.logs_in_with(username, password);
    }

    @Step
    public void adds_items_to_the_cart(String... itemNames) {
        this.itemNames = itemNames;
        Arrays.stream(itemNames)
                .forEach(itemName -> inventoryPage.add_item(itemName));
    }

    @Step
    public void should_see_the_products_added_to_the_cart() {
        menuBar.go_to_shopping_cart();

        List<String> itemsDisplayedInCart = cartPage.return_products_list().stream()
                .map(item -> item.get("name"))
                .collect(Collectors.toList());

        assertThat(cartPage.return_products_list(), hasSize(itemNames.length));
        assertThat(itemsDisplayedInCart, hasItems(itemNames));
    }
}
