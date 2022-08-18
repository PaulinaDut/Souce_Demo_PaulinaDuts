package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage extends BasePage {
    private By userFirstInput = By.id("first-name");
    private By userLastInput = By.id("last-name");
    private By userPostalCodeInput = By.id("postal-code");
    private By errorMessageContainer = By.cssSelector("div.error-message-container");
    private By continueButton = By.id("continue");
    private By cancelButton = By.id("cancel");

    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
    }


    public void setFirstName(String firstName) {
        driver.findElement(userFirstInput).sendKeys(firstName);

    }
    public void setLastName(String lastName) {
        driver.findElement(userLastInput).sendKeys(lastName);

    }
    public void setPostalCode(String postalCode) {
        driver.findElement(userPostalCodeInput).sendKeys(postalCode);

    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public boolean isErrorMessageContainerDisplayed() {
        return driver.findElement(errorMessageContainer).isDisplayed();
    }
    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessageContainer).getText();
    }
    public void checkoutYourInformationForm(String firstName, String lastName, String postalCode) {

    }

    public void setCheckoutYourInformationForm() {
        setFirstName("Terry");
        setLastName("Berry");
        setPostalCode("12345");

    }




}
