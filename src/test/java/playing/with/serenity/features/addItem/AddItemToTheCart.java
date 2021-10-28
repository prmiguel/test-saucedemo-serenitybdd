package playing.with.serenity.features.addItem;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import playing.with.serenity.BaseTests;
import playing.with.serenity.steps.serenity.AddItemToTheCartSteps;

@RunWith(SerenityRunner.class)
public class AddItemToTheCart extends BaseTests {

    @Steps
    public AddItemToTheCartSteps anna;

    @Test
    public void add_item_should_display_the_product_in_the_cart() {
        anna.adds_item_to_the_cart("Sauce Labs Fleece Jacket");
        anna.should_see_the_product_added_to_the_cart();
    }
} 