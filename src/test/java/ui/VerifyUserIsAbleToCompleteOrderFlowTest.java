package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.constants.Constants;

public class VerifyUserIsAbleToCompleteOrderFlowTest extends BaseTest {

    @Test
    public void verifyUserIsAbleToCompleteOrderFlow() {
        loginPage.loginUser(Constants.STANDARD_USER, Constants.PASSWORD);
        productsPage.addToCart(Constants.BOLT_T_SHIRT).click();
        productsPage.addToCart(Constants.BIKE_LIGHT).click();
        productsPage.determineShoppingCartHasItems();
        productsPage.shoppingCart().click();
        var shoppingCartsItems = productsPage.shoppingCart().getText();
        Assert.assertEquals(shoppingCartsItems, Constants.TWO_ITEMS_IN_CART,
                String.format("Assertion failed due to wrong number of products in cart, should be %s b ut there are %s.", Constants.TWO_ITEMS_IN_CART, shoppingCartsItems));
        cartPage.getCheckoutButton().click();
        checkoutPage.getFirstNameInput().sendKeys(Constants.JOHN);
        checkoutPage.getLastNameInput().sendKeys(Constants.DOE);
        checkoutPage.getPostalCodeInput().sendKeys(Constants.POSTAL_CODE);
        checkoutPage.getContinueButton().click();
        checkoutPage.waitForFinishButtonToBeClickable();
        checkoutPage.getFinishButton().click();
        var thankText = checkoutPage.getThankForOrderText().getText();
        Assert.assertEquals(thankText, Constants.THANKS_FOR_ORDER,
                String.format("Assertion failed due to checkout message not shown, should be %s but is %s.", Constants.THANKS_FOR_ORDER, thankText));
    }
}
