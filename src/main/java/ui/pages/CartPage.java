package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.constants.Constants;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By checkoutButton = By.id("checkout");

    public WebElement getCheckoutButton() {
        return driver.findElement(checkoutButton);
    }

    public WebElement getCheckoutList() {
        return driver.findElement(By.className(Constants.CART_LIST));
    }
}
