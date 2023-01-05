package ui;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.constants.Constants;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class ProductNamesToTxtTest extends BaseTest {

    @BeforeTest
    public void loginAndGetToProductsPage() {
        loginPage.loginUser(Constants.STANDARD_USER, Constants.PASSWORD);
    }

    @Test
    public void writeToFile() throws IOException {
        File file = new File("productNames.txt");
        String items;
        var listOfItems = new ArrayList<>();
        int itemsNumber = productsPage.getInventoryItems().size();
        for (int i = 0; i < itemsNumber; i++) {
             items = productsPage.getInventoryItems().get(i).getText();
             listOfItems.add(String.format("%n" + items));
        }
        FileUtils.writeStringToFile(file, listOfItems.toString(), Charset.defaultCharset());
    }
}
