package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCompleteTests extends BaseTest{
    @Test(groups = {"Smoke"})
    public void backHomeOnCompleteCheckoutTest() {
        loginPage.login(TEST_USER_NAME, TEST_PASSWORD);
        productsPage.clickAddToCardButton(TEST_ITEM_NAME);
        productsPage.clickShoppingCartLink();
        cartPage.clickCheckoutButton();
        checkoutYourInformationPage.setCheckoutYourInformationForm("Terry", "Berry", "12345");
        checkoutYourInformationPage.clickContinueButton();
        checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(checkoutCompletePage.thankYouTextIsDisplayed());
        checkoutCompletePage.clickBackHomeButton();
        Assert.assertTrue(productsPage.isHeaderContainerDisplayed());
    }
}
