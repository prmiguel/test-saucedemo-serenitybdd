package playing.with.serenity.features.sortItems;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import playing.with.serenity.BaseTests;
import playing.with.serenity.pages.SortingOptions;
import playing.with.serenity.steps.serenity.SortProductsByPriceSteps;

@RunWith(SerenityRunner.class)
public class SortProductsByPrice extends BaseTests {

    @Steps
    public SortProductsByPriceSteps anna;

    @Test
    public void sort_products_by_price_should_display_products_ordered_from_low_to_high() {
        anna.sorts_the_products_by_price(SortingOptions.PRICE_LOW_TO_HIGH);
        anna.should_see_products_sorted_by_low_price_to_high();
    }
} 