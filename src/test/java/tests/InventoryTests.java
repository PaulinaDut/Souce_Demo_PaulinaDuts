package tests;

import helpers.FileFormat;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestDataParser;

public class InventoryTests extends BaseTest {
    @DataProvider
    public Object[][] inventoryDataProvider() {
        TestDataParser parser = new TestDataParser(FileFormat.JSON);
        return parser.readLinearStructure("inventory-test-data-provider.json");
    }

    @Test(dataProvider ="inventoryDataProvider", groups = {"Smoke"})
    public void productItemDescriptionTest(String productName, String expectedDescription, String expectedPrice) {
        loginPage.login(TEST_USER_NAME, TEST_PASSWORD);
        String actualPrice= productsPage.getProductPrice(productName);
        String actualDescription = productsPage.getProductDescription(productName);
        Assert.assertEquals(actualPrice, expectedPrice);
        Assert.assertEquals(actualDescription, expectedDescription);
    }

    @Test(groups = {"Smoke"})
    public void logoutFromBurgerMenuTest() {
        loginPage.login(TEST_USER_NAME, TEST_PASSWORD);
        productsPage.clickBurgerMenu();
        productsPage.clickLogout();
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
    }




}
