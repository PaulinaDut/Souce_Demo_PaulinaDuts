package tests;

import helpers.FileFormat;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestDataParser;



public class ItemDetailsTests extends BaseTest {
    @Test(dataProvider = "itemDetailsTestsDataProvider", groups={"Regression"})
    public void itemDetailsDescriptionTest(String productName, String expectedItemDetailsDescription, String expectedItemDetailsPrice) {
        loginPage.login(TEST_USER_NAME, TEST_PASSWORD);
        productsPage.openProductDetails(productName);
        String actualItemDetailsPrice = detailsPage.getItemDetailsPrice();
        String actualItemDetailsDescription = detailsPage.getItemDetailsDescription();
        Assert.assertEquals(actualItemDetailsPrice, expectedItemDetailsPrice);
        Assert.assertEquals(actualItemDetailsDescription, expectedItemDetailsDescription);

    }

    @DataProvider
    public Object[][] itemDetailsTestsDataProvider() {
        TestDataParser parser = new TestDataParser(FileFormat.JSON);
        return parser.readLinearStructure("item-details-tests-data-provider.json");
    }
}
