package tests;

import helpers.FileFormat;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestDataParser;


public class LoginTests extends BaseTest {

    @Test(groups = {"Smoke","Regression"})
    public void positiveLoginTest() {
        loginPage.login(TEST_USER_NAME, TEST_PASSWORD);
        Assert.assertTrue(productsPage.isHeaderContainerDisplayed());

    }

    @Test(dataProvider = "loginNegativeTestDataProvider", groups={"Negative"})
    public void negativeLoginTest(String username, String password, String expectedMessage) {
        loginPage.setUserNameInputValue(username);
        loginPage.setPasswordInputValue(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageContainerDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage(), expectedMessage);

    }
    @DataProvider
    public Object[][] loginNegativeTestDataProvider() {
        TestDataParser parser = new TestDataParser(FileFormat.JSON);
        return parser.readLinearStructure("login-negative-test-data-provider.json");
    }
}