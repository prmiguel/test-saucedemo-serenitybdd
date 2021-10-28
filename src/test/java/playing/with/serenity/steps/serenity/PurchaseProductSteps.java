package playing.with.serenity.steps.serenity;

import net.thucydides.core.annotations.Step;
import playing.with.serenity.pages.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class PurchaseProductSteps {

    InventoryPage inventoryPage;
    MenuBar menuBar;
    CartPage cartPage;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletePage checkoutCompletePage;

    @Step
    public void starts_the_checkout_for_product(String itemName) {
        inventoryPage.add_item(itemName);
        menuBar.go_to_shopping_cart();
        cartPage.start_checkout_process();
    }

    @Step
    public void provides_personal_information(String firstName, String lastName, String zipPostalCode) {
        checkoutInformationPage.provide_checkout_information(firstName, lastName, zipPostalCode);
        checkoutInformationPage.continue_with_checkout_process();
    }

    @Step
    public void confirm_checkout_details_with_a_total_of(String totalPrice) {
        assertThat(checkoutOverviewPage.getTotal(), containsString(totalPrice));
        checkoutOverviewPage.finish_checkout_process();
    }

    @Step
    public void should_see_the_purchase_completed_with_message(String message, String description) {
        assertThat(checkoutCompletePage.getOrderTitle(), equalTo(message));
        assertThat(checkoutCompletePage.getOrderDescription(), equalTo(description));
    }
}
