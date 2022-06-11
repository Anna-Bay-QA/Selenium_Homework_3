package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CountryPage {
    private WebDriver driver;
    private final By TermsConditionsCheck = By.cssSelector("div .wrapperTwo input[type='checkbox']");
    private final By proceedBtn = By.cssSelector("div .wrapperTwo button");
    private final By successfulOrderText = By.xpath("//*[contains(text(), 'Thank you, your order has been placed successfully')]");

    public CountryPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement agreeCheckbox(){
        return driver.findElement(TermsConditionsCheck);
    }

    public void clickProceed(){
        driver.findElement(proceedBtn).click();
    }

    public WebElement successText(){
        return driver.findElement(successfulOrderText);
    }
}
