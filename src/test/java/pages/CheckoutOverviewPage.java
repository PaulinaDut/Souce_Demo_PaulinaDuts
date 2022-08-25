package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
    private By finishButton = By.id("finish");
    private By itemPrice = By.cssSelector("div.summary_subtotal_label");
    private By cancelButton = By.id("cancel");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }
    public boolean finishButtonIsDisplayed(){
        return driver.findElement(finishButton).isDisplayed();
    }
    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }

    public String getItemPrice() {
        return driver.findElement(itemPrice).getText();
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }

}
