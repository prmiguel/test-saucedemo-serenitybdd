package playing.with.serenity.features.addItem;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import playing.with.serenity.BaseTests;
import playing.with.serenity.steps.serenity.AddItemsToTheCartSteps;

@RunWith(SerenityRunner.class)
public class AddItemsToTheCart extends BaseTests {

    @Steps
    public AddItemsToTheCartSteps anna;

    @Test
    public void add_items_should_display_the_products_in_the_cart() {
        anna.adds_items_to_the_cart("Sauce Labs Fleece Jacket",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Bike Light");
        anna.should_see_the_products_added_to_the_cart();
    }
} 