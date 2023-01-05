package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    By firstNameInput = By.id("first-name");
    By lastNameInput = By.id("last-name");
    By postalcodeInput = By.id("postal-code");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");
    By thankForOrderText = By.xpath("//h2[@class='complete-header']");

    public WebElement getFirstNameInput() {
        return driver.findElement(firstNameInput);
    }

    public WebElement getLastNameInput() {
        return driver.findElement(lastNameInput);
    }

    public WebElement getPostalCodeInput() {
        return driver.findElement(postalcodeInput);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButton);
    }

    public void waitForFinishButtonToBeClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton));
    }

    public WebElement getFinishButton() {
        return driver.findElement(finishButton);
    }

    public WebElement getThankForOrderText() {
        return driver.findElement(thankForOrderText);
    }
}
