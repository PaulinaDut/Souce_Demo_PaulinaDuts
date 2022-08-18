package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutCompletePage extends BasePage {
    private By thankYouText = By.cssSelector("h2[class='complete-header']");
    private By backHomeButton = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean thankYouTextIsDisplayed() {
        return driver.findElement(thankYouText).isDisplayed();
    }
    public void clickBackHomeButton() {
        driver.findElement(backHomeButton).click();
    }

}
