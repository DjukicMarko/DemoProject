package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    By shoppingCartBadge = By.className("shopping_cart_badge");
    By inventoryItems = By.xpath("//div[@class='inventory_item_name']");

    public WebElement addToCart(String product) {
        return driver.findElement(By.xpath(String.format("//button[@data-test='add-to-cart-%s']", product)));
    }

    public WebElement removeFromCart(String product) {
        return driver.findElement(By.xpath(String.format("//button[@data-test='remove-%s']", product)));
    }

    public void determineShoppingCartHasItems() {
        wait.until(ExpectedConditions.presenceOfElementLocated(shoppingCartBadge));
    }

    public WebElement shoppingCart() {
        return driver.findElement(shoppingCartBadge);
    }

    public List<WebElement> getInventoryItems() {
        return driver.findElements(inventoryItems);
    }
}
