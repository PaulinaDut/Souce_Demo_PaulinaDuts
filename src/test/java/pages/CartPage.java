package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private By removeButton = By.xpath("//button[text() = 'Remove']");
    private String itemContainer = "//div[@class='inventory_item_name' and text() = '%s']/ancestor::div[@class = 'cart_item']";
    private By cartProductDescription = By.cssSelector("div.inventory_item_desc");
    private By checkoutButton = By.id("checkout");
    private By continueShoppingButton = By.id("continue-shopping");
    private By cartProductPrice = By.cssSelector("div.inventory_item_price");
    private By cartQuantity = By.cssSelector("div.cart_quantity");



    public CartPage(WebDriver driver) {
        super(driver);
    }
    public String getProductQuantity(String productName) {
        WebElement productContainer = getProductContainer(productName);
        return productContainer.findElement(cartQuantity).getText();
    }

    public void clickRemoveButton() {
        driver.findElement(removeButton).click();
    }
    public String getCartProductDescription() {
        return driver.findElement(cartProductDescription).getText();
    }
    public String getCartProductPrice() {
        return driver.findElement(cartProductPrice).getText();
    }
    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }
    public void clickContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
    }


    private WebElement getProductContainer(String productName) {
        return driver.findElement(By.xpath
                (String.format(itemContainer, productName)
                ));
    }


}
