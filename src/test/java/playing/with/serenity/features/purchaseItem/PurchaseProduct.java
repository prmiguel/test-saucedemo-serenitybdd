package playing.with.serenity.features.purchaseItem;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import playing.with.serenity.steps.serenity.PurchaseProductSteps;

@RunWith(SerenityRunner.class)
public class PurchaseProduct {

    @Managed
    public WebDriver webdriver;

    @Steps
    public PurchaseProductSteps anna;

    @Test
    public void complete_checkout_process_should_purchase_the_product() {
        anna.is_logged_in_with_credentials("standard_user", "secret_sauce");
        anna.starts_the_checkout_for_product("Sauce Labs Fleece Jacket");
        anna.provides_personal_information("Miguel", "Angel", "0000");
        anna.confirm_checkout_details_with_a_total_of("$53.99");
        anna.should_see_the_purchase_completed_with_message("THANK YOU FOR YOUR ORDER",
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }
} 