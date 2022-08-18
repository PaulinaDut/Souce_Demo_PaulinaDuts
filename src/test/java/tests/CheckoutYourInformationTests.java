package tests;

import helpers.FileFormat;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestDataParser;

public class CheckoutYourInformationTests extends BaseTest{
    @DataProvider
    public Object[][] checkoutYourInfoNegativeTestDataProvider() {
        TestDataParser parser = new TestDataParser(FileFormat.JSON);
        return parser.readLinearStructure("checkout-your-info-negative-test-data-provider.json");
    }

    @Test(dataProvider = "checkoutYourInfoNegativeTestDataProvider", groups = {"Negative"})
    public void checkoutYourInformationNegativeTest(String firstName, String lastName, String PostalCode, String expectedErrorMessage) {
        loginPage.login();
        productsPage.clickAddToCardButton(TEST_ITEM_NAME);
        productsPage.clickShoppingCartLink();
        cartPage.clickCheckoutButton();
        checkoutYourInformationPage.setFirstName(firstName);
        checkoutYourInformationPage.setLastName(lastName);
        checkoutYourInformationPage.setPostalCode(PostalCode);
        checkoutYourInformationPage.clickContinueButton();
        Assert.assertEquals(checkoutYourInformationPage.getErrorMessage(), expectedErrorMessage, "Error message is not as expected");
        checkoutYourInformationPage.clickCancelButton();
        cartPage.clickRemoveButton();




    }
}
