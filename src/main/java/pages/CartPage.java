package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private final WebDriver driver;
    private final By placeOrderBtn = By.cssSelector("div.products span.discountAmt + br+ br+ button");
    private final By rowsOfItemTable = By.cssSelector("div .products tbody tr");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getRowsOfTable(){
        return driver.findElements(rowsOfItemTable);
    }

    public CountryPage clickPlaceOrderBtn(){
        driver.findElement(placeOrderBtn).click();
        return new CountryPage(driver);
    }



}
