package pageobjects;

import baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketData extends BaseClass {

    private By marketdata = By.cssSelector("a[id='link_2']");

    public void goToMarketData() throws InterruptedException {
        driver.findElement(marketdata).isDisplayed();
        Thread.sleep(6000);
    }
}
