package playing.with.serenity.steps.serenity;

import net.thucydides.core.annotations.Step;
import playing.with.serenity.pages.InventoryPage;
import playing.with.serenity.pages.SortingOptions;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SortProductsByPriceSteps {

    public Comparator<Map<String, String>> comparatorByPrice = (m1, m2) -> {
        double price1 = Double.parseDouble(m1.get("price").replace("$", ""));
        double price2 = Double.parseDouble(m2.get("price").replace("$", ""));
        return Double.compare(price1, price2);
    };

    InventoryPage inventoryPage;
    List<Map<String, String>> products;

    @Step
    public void sorts_the_products_by_price(SortingOptions sortingOption) {
        products = inventoryPage.return_products_list();
        inventoryPage.sort_products_by(sortingOption.getText());
    }

    @Step
    public void should_see_products_sorted_by_low_price_to_high() {
        products.sort(comparatorByPrice);
        assertThat(inventoryPage.return_products_list(), equalTo(products));
    }
}
