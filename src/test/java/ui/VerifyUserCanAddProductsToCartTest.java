package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.constants.Constants;

public class VerifyUserCanAddProductsToCartTest extends BaseTest {

    @BeforeTest
    public void loginToApp() {
        loginPage.loginUser(Constants.STANDARD_USER, Constants.PASSWORD);
    }

    @Test
    public void addToCartTest() {
        productsPage.addToCart(Constants.BIKE_LIGHT).click();
        productsPage.addToCart(Constants.BOLT_T_SHIRT).click();
        productsPage.addToCart(Constants.OONSIE).click();
        productsPage.determineShoppingCartHasItems();
        var cart = productsPage.shoppingCart().getText();
        Assert.assertTrue(cart.contains(Constants.THREE_ITEMS_IN_CART),
                String.format("Assertion failed, wrong number of products in cart, there should be %s, but there is %s", Constants.THREE_ITEMS_IN_CART, cart));
        var cartItems = cartPage.getCheckoutList().getText();
        Assert.assertTrue(cartItems.contains(Constants.BIKE_LIGHT));
    }

}
