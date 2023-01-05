package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.constants.Constants;

public class VerifyUserCanRemoveProductsFromCartTest extends BaseTest {

    @BeforeTest
    public void loginAndAddProductsToCart() {
        loginPage.loginUser(Constants.STANDARD_USER, Constants.PASSWORD);
        productsPage.addToCart(Constants.OONSIE).click();
        productsPage.addToCart(Constants.BOLT_T_SHIRT).click();
        productsPage.shoppingCart().click();
    }

    @Test
    public void verifyUserCanRemoveProductsFromCartTest() {
        productsPage.removeFromCart(Constants.OONSIE).click();
        var numberOfItems = productsPage.shoppingCart().getText();
        Assert.assertEquals(numberOfItems, Constants.ONE_ITEM_IN_CART,
                String.format("Assertion failed due to wrong number of products left in the cart, should be %s but there is %s.", Constants.ONE_ITEM_IN_CART, numberOfItems));
    }
}
