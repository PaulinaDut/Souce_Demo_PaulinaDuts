package tests;


import helpers.FileFormat;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestDataParser;

public class CheckoutOverviewTests extends BaseTest {

    @Test(dataProvider = "checkoutOverviewDataProvider", groups = {"Regression"})
    public void checkoutOverviewTotalPriceTest(String productName, String TotalPrice) {
        loginPage.login(TEST_USER_NAME, TEST_PASSWORD);
        productsPage.clickAddToCardButton(productName);
        productsPage.clickShoppingCartLink();
        cartPage.clickCheckoutButton();
        checkoutYourInformationPage.setCheckoutYourInformationForm("Terry", "Berry", "12345");
        checkoutYourInformationPage.clickContinueButton();
        String actualItemPrice = checkoutOverviewPage.getItemPrice();
        Assert.assertEquals(actualItemPrice, TotalPrice );
        Assert.assertTrue(checkoutOverviewPage.finishButtonIsDisplayed());
        checkoutOverviewPage.clickCancelButton();
        productsPage.clickRemoveButton(productName);

    }

    @DataProvider
    public Object[][] checkoutOverviewDataProvider() {
        TestDataParser parser = new TestDataParser(FileFormat.JSON);
        return parser.readLinearStructure("checkout-overview-data-provider.json");


    }
}
