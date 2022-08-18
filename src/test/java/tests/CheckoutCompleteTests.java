package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCompleteTests extends BaseTest{
    @Test(groups = {"Smoke"})
    public void backHomeOnCompleteCheckoutTest() {
        loginPage.login();
        productsPage.clickAddToCardButton(TEST_ITEM_NAME);
        productsPage.clickShoppingCartLink();
        cartPage.clickCheckoutButton();
        checkoutYourInformationPage.setCheckoutYourInformationForm();
        checkoutYourInformationPage.clickContinueButton();
        checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(checkoutCompletePage.thankYouTextIsDisplayed());
        checkoutCompletePage.clickBackHomeButton();
        Assert.assertTrue(productsPage.isHeaderContainerDisplayed());
    }
}
