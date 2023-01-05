package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");
    By productsTitle = By.xpath("//span[text()='Products']");

    public WebElement getUsernameInput() {
        return driver.findElement(usernameInput);
    }

    public WebElement getPasswordInput() {
        return driver.findElement(passwordInput);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    public WebElement getProductsTitle() {
        return driver.findElement(productsTitle);
    }

    public void loginUser(String name, String password) {
        getUsernameInput().sendKeys(name);
        getPasswordInput().sendKeys(password);
        getLoginButton().click();
    }
}