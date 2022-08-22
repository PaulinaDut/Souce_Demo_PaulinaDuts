package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage{
    private By shoppingCartLink = By.cssSelector("a[class='shopping_cart_link");
    private By headerContainer = By.id("header_container");
    private String itemContainer = "//div[@class='inventory_item_name' and text() = '%s']/ancestor::div[@class = 'inventory_item']";
    private By itemDetailsLink = By.cssSelector("a[id$=_title_link");
    private By removeButton = By.cssSelector("button[id^=remove-]");
    private By addToCartButton = By.cssSelector("button[id^=add-]");
    private By productPrice = By.cssSelector("div.inventory_item_price");
    private By productDescription = By.cssSelector("div.inventory_item_desc");
    private By burgerMenu = By.id("react-burger-menu-btn");
    private By crossButton = By.id("react-burger-cross-btn");
    private By allItemsBurgerMenuItem = By.id("inventory_sidebar_link");
    private By LogoutBurgerMenuItem = By.id("logout_sidebar_link");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public boolean isHeaderContainerDisplayed() {
        return driver.findElement(headerContainer).isDisplayed();
    }

    public String getProductPrice(String productName) {
        WebElement productContainer = getProductContainer(productName);
        return productContainer.findElement(productPrice).getText();


    }

    public String getProductDescription(String productName) {
        WebElement productContainer = getProductContainer(productName);
        return productContainer.findElement(productDescription).getText();

    }

    public void clickAddToCardButton(String productName) {
        WebElement productContainer = getProductContainer(productName);
        productContainer.findElement(addToCartButton).click();

    }

    public void clickRemoveButton(String productName) {
        WebElement productContainer = getProductContainer(productName);
        productContainer.findElement(removeButton).click();

    }

    public void openProductDetails(String productName) {
        WebElement productContainer = getProductContainer(productName);
        productContainer.findElement(itemDetailsLink).click();

    }
    public void clickShoppingCartLink() {
        WebElement shoppingCart = driver.findElement(shoppingCartLink);
        shoppingCart.click();
    }

    public void clickBurgerMenu() {
        driver.findElement(burgerMenu).click();

    }
    public void clickBurgerCrossButton() {
        driver.findElement(crossButton).click();
    }

    public void clickAllItems(){
        driver.findElement(allItemsBurgerMenuItem).click();
    }
    public void clickLogout(){
        driver.findElement(LogoutBurgerMenuItem).click();
    }



    private WebElement getProductContainer(String productName) {
        return driver.findElement(By.xpath
                (String.format(itemContainer, productName)
                ));
    }






}
