package tests;

import helpers.FileFormat;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestDataParser;

public class CartTests extends BaseTest {
    @DataProvider
    public Object[][] itemDetailsTestsDataProvider() {
        TestDataParser parser = new TestDataParser(FileFormat.JSON);
        return parser.readLinearStructure("item-details-tests-data-provider.json");
    }
    @DataProvider
    public Object[][] cartQuantityTestsDataProvider() {
        TestDataParser parser = new TestDataParser(FileFormat.JSON);
        return parser.readLinearStructure("cart-quantity-test-data-provider.json");
    }

    @Test(dataProvider = "itemDetailsTestsDataProvider", groups={"Smoke"})
    public void cartPositiveTest(String productName,
                                                     String expectedItemDetailsDescription,
                                                     String expectedItemDetailsPrice) {
        loginPage.login();
        productsPage.clickAddToCardButton(productName);
        productsPage.clickShoppingCartLink();
        String actualCartProductDescription = cartPage.getCartProductDescription();
        String actualCartProductPrice = cartPage.getCartProductPrice();
        Assert.assertEquals(actualCartProductDescription, expectedItemDetailsDescription);
        Assert.assertEquals(actualCartProductPrice, expectedItemDetailsPrice);
        cartPage.clickRemoveButton();
        cartPage.clickContinueShoppingButton();
        Assert.assertTrue(productsPage.isHeaderContainerDisplayed());
    }

    @Test(dataProvider = "cartQuantityTestsDataProvider", groups = "Regression")
    public void cartQuantityTest(String productName, String expectedCartQuantity) {
        loginPage.login();
        productsPage.clickAddToCardButton(productName);
        productsPage.clickShoppingCartLink();
        String actualCartQuantity = cartPage.getProductQuantity(productName);
        Assert.assertEquals(actualCartQuantity, expectedCartQuantity, "Cart quantity is not correct");

    }


}
