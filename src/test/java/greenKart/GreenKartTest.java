package greenKart;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CountryPage;

import java.time.Duration;
import java.util.List;

import static constants.Constants.*;


public class GreenKartTest extends BaseTest {

    @Test
    public void openCartPage() {

        //Assert HomePage is opened
        Assert.assertEquals(HOME_PAGE_URL, driver.getCurrentUrl());
        Assert.assertEquals(HOME_PAGE_TITLE, driver.getTitle());

        // ((JavascriptExecutor) driver).executeScript("window.scroll(0,1550)", "");

        homePage.clickAddCartMangoBtn();

        String mangoPrice = homePage.findMangoPrice();
        String mangoCount = homePage.findMangoCount();

        homePage.clickCartIcon();

        String cartPriceValue = homePage.findCartPrice();
        String cartItemValue = homePage.findCartItem();

        //Assert Items and Price are shown as expected in the cart-info
        Assert.assertEquals(mangoPrice, cartPriceValue);
        Assert.assertEquals(mangoCount, cartItemValue);

        String mangoImage = homePage.findMangoImg();
        //Assert "Mango" is shown on overlay
        Assert.assertTrue(mangoImage.contains("mango"));

        /////////////////////////////////////////////////////
        //Navigate to CartPage
        CartPage cartPage = homePage.clickProceedCheckoutBtn();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.urlContains("cart"));
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Thread.sleep(5000);
        Assert.assertEquals(CART_PAGE_URL, driver.getCurrentUrl());

        List<WebElement> tr = cartPage.getRowsOfTable();
        int countTR = tr.size();
        Assert.assertEquals(countTR, 1);

        /////////////////////////////////////////////////////
        //Navigate to CountryPage
        CountryPage countryPage = cartPage.clickPlaceOrderBtn();
        Assert.assertEquals(COUNTRY_PAGE_URL, driver.getCurrentUrl());

        WebElement agreeChecked = countryPage.agreeCheckbox();
        agreeChecked.click();
        Assert.assertTrue(agreeChecked.isSelected());

        countryPage.clickProceed();

        WebElement successTXT = countryPage.successText();
        Assert.assertTrue(successTXT.isDisplayed());


    }
}
