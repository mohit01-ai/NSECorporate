package pageobjects;

import baseclass.SeleniumReusuable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utilities.CsvReader;
import utilities.ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;


public class MarketData {
    WebDriver driver;
    SeleniumReusuable sr;
    WebDriverWait wait;
    Actions action;

    public MarketData(WebDriver driver) {
        this.driver = driver;
        sr = new SeleniumReusuable(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
    }

    private final By marketdata = By.cssSelector("a[id='link_2']");
    private final By gainloss = By.id("Gainers/Losers");
    private final By indexDropdown = By.id("index0");
    private final By topGainersList = By.xpath("//tr[@class=' ']");
    private final By topGainersDownload = By.cssSelector(".gainers-dwldcsv");


    public void goToMarketData() throws InterruptedException {
        Thread.sleep(2000);
        sr.hover(marketdata);
//        sr.clickByVisibilityOfElement(marketdata);


    }

    public void gainersLosers() {
        sr.clickByVisibilityOfElement(gainloss);
    }

    public void selectIndex(String indexName) throws InterruptedException {
        sr.selectByVisibleText(indexDropdown, indexName);
        Thread.sleep(5000);
    }

    public void verifyNoOfTopGainers(int num) {
        SoftAssert softassert = new SoftAssert();
        List<WebElement> list = driver.findElements(topGainersList);
        int listSize = list.size();
        int noOfStocks = list.size() / 2;
        if (listSize % 2 != 0) noOfStocks = noOfStocks - 1;
        if (num == noOfStocks) {
            softassert.assertTrue(true, "No of top Gainers are 20");
        } else {
            softassert.fail("No of Stock are not 20 i.e : " + noOfStocks);
        }
        softassert.assertAll();
    }

    public void downloadFile() {
        sr.clickByVisibilityOfElement(topGainersDownload);
    }

    public void verifyFileDownload() {
        String downloadFilePath = "C:\\Users\\kaush\\Downloads";
        File[] folder = new File(downloadFilePath).listFiles();
        boolean downloaded = false;

        assert folder != null;
        for (File file : folder) {
            if (file.getName().startsWith("T20-GL-gainers-")) {
                downloaded = true;
                if (downloaded) file.delete();
                break;
            }
        }
        if (downloaded) {
            Assert.assertTrue(downloaded, "Top 20 gainers file is downloaded successfully");
        } else Assert.fail("Top 20 gainers file is not downloaded");


    }

    public void verifyUpperCircuit() throws Exception {
        String path = "C:/Users/kaush/Downloads";
        File[] files = new File(path).listFiles();
        double data = 0;
        assert files != null;
        for (File file : files) {
            if (file.getName().startsWith("T20-GL-gainers-")) {

                data = Double.parseDouble(CsvReader.getCellData(file.getAbsolutePath(), 1, 6));
                break;
            }
        }
        if (data == 19.99 || data == 20.00) {
            Assert.assertTrue(true, "The upper circuit is :" + data);
        } else {
            Assert.fail("The upper circuit is :" + data);
        }
    }
}
