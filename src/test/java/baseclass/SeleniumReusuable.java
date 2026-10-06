package baseclass;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SeleniumReusuable {
    WebDriver driver;
    Actions action;
    WebDriverWait wait;
    Select select;

    public SeleniumReusuable(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void clickByElementToBeClickable(By path) {
        wait.until(ExpectedConditions.elementToBeClickable(path)).click();

    }

    public void elementToBeClickable(By path) {
        wait.until(ExpectedConditions.elementToBeClickable(path));

    }

    public void clickByVisibilityOfElement(By path) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(path)).click();
    }

    public void isElementDisplayed(By path) {
        WebElement ele = driver.findElement(path);
        try {
            ele.isDisplayed();
        } catch (Exception e) {
            System.out.println("Element is not displayed");
        }
    }

    public void hover(By path) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(path));
        action.moveToElement(ele).build().perform();
    }

    public void selectByVisibleText(By dropdown, String text) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown));
        select = new Select(ele);
        select.selectByVisibleText(text);

    }

    public void moveToElementClick(By path) {

        WebElement ele = wait.until(
                ExpectedConditions.visibilityOfElementLocated(path)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'center'});",
                ele
        );

        wait.until(ExpectedConditions.elementToBeClickable(ele));

        try {
            ele.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", ele
            );
        }
    }
}