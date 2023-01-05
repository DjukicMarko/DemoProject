package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.constants.Constants;

public class VerifyUserIsAbleToLoginTest extends BaseTest {


    @Test
    public void login() {
        loginPage.getUsernameInput().sendKeys(Constants.STANDARD_USER);
        loginPage.getPasswordInput().sendKeys(Constants.PASSWORD);
        loginPage.getLoginButton().click();
        var title = loginPage.getProductsTitle().getText();
        Assert.assertEquals(title, Constants.PRODUCTS,
                String.format("Assertion failed, we should be seeing %s but we are seeing %s", Constants.PRODUCTS, title));
    }
}
