package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
    private final WebDriver driver;
    private final By addCart = By.cssSelector("div .products div:nth-child(18) button[type='button']");
    private final By price = By.cssSelector("div .products div:nth-child(18) .product-price");
    private final By count = By.cssSelector("div .products div:nth-child(18) .stepper-input input");
    private final By cartIcon = By.cssSelector("div .cart .cart-icon img");
    private final By cartItem = By.cssSelector("div .cart-info tr:nth-child(1) td strong");
    private final By cartPrice = By.cssSelector("div .cart-info tr:nth-child(2) td strong");
    private final By mangoImg = By.cssSelector("div .cart-preview img");
    private final By proceedCheckoutBtn = By.cssSelector("div .cart-preview button");



    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public  void clickAddCartMangoBtn(){
        driver.findElement(addCart).click();
    }

    public String findMangoPrice(){
       return driver.findElement(price).getAttribute("innerHTML");
    }

    public String findMangoCount(){
        return driver.findElement(count).getAttribute("value");
    }

    public void clickCartIcon(){
       driver.findElement(cartIcon).click();
    }

   public String findCartItem(){
        return driver.findElement(cartItem).getAttribute("innerHTML");
    }

    public String findCartPrice(){
       return driver.findElement(cartPrice).getAttribute("innerHTML");
    }

    public String findMangoImg(){
        return driver.findElement(mangoImg).getAttribute("src");
    }

    public CartPage clickProceedCheckoutBtn(){
        driver.findElement(proceedCheckoutBtn).click();
        return new CartPage(driver);
    }


}