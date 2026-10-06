package stepdefinitions;

import baseclass.Driverfactory;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.LaunchApp;
import pageobjects.MarketData;

public class MarketDataStepDefinition  {
    WebDriver driver;
    public LaunchApp la;
    public MarketData md;

    public MarketDataStepDefinition() {
        driver = Driverfactory.getDriver();
        la = new LaunchApp(driver);
        md= new MarketData(driver);
    }

    @Given("the user launch the application")
    public void the_user_launch_the_application() {
        la.launchUrl();
    }

    @When("the user go to market data")
    public void theUserGoToMarketData() throws InterruptedException {
       md.goToMarketData();
    }

    @When("the user go to Gainers losers")
    public void theUserGoToGainersLosers() throws InterruptedException {
        md.gainersLosers();
    }

    @When("the user select the index {string}")
    public void theUserSelectTheIndex(String index) throws InterruptedException {
       md.selectIndex(index);

    }

    @Then("verify the top {int} gainers are available")
    public void verifyTheTopGainersAreAvailable(int num) {
       md.verifyNoOfTopGainers(num);
    }

    @When("the user click on download file")
    public void theUserClickOnDownloadFile() throws InterruptedException {
      md.downloadFile();

    }

    @Then("verify the file is downloaded")
    public void verifyTheFileIsDownloaded() throws InterruptedException {
        md.verifyFileDownload();

    }

    @Then("verify the top gainer has a twenty percent upper circuit")
    public void verifyTheTopGainerHasATwentyPercentUpperCircuit() throws Exception {
       md.verifyUpperCircuit();
    }
}
