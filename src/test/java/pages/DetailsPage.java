package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailsPage extends BasePage{
    private By itemDetailsPrice = By.cssSelector("div.inventory_details_price");
    private By itemDetailsDescription = By.cssSelector("div.inventory_details_desc.large_size");

    public DetailsPage(WebDriver driver) {
        super(driver);
    }
    public String getItemDetailsPrice() {
        return driver.findElement(itemDetailsPrice).getText();
    }

    public String getItemDetailsDescription() {
        return driver.findElement(itemDetailsDescription).getText();

    }

}
