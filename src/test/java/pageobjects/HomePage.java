package pageobjects;

import baseclass.SeleniumReusuable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class HomePage {
    WebDriver driver;
    SeleniumReusuable sr;
    Set<String> list;

    By homeIcon = By.linkText("Home");
    By indexName = By.tagName("h1");
    By slickNext = By.cssSelector(".slick-arrow.slick-next");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        sr = new SeleniumReusuable(driver);

    }

    public void clickHomeIcon() {
        sr.moveToElementClick(homeIcon);

    }

    public void getIndexNames() {
        list = new LinkedHashSet<>();

        for (int i = 0; i <= 45; i++) {
            list.add(driver.findElement(indexName).getText());
            sr.clickByElementToBeClickable(slickNext);
        }

        System.out.println("Total indexes found: " + list.size());

        Assert.assertEquals(
                list.size(), 15,
                "Expected 15 indexes but found " + list.size()
        );
    }

    public void verifyIndexNames(List<String> expected) {
        SoftAssert softassert = new SoftAssert();
        for (String currName : expected) {
            softassert.assertTrue(list.contains(currName), "Index not found on page : " + currName);
        }
        softassert.assertAll();
    }
}
