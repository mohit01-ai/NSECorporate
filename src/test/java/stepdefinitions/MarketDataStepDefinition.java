package stepdefinitions;

import baseclass.BaseClass;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageobjects.LaunchApp;
import pageobjects.MarketData;

public class MarketDataStepDefinition extends BaseClass {
    public LaunchApp la;
    public MarketData md;

    public MarketDataStepDefinition() {
        super();
        la = new LaunchApp();
        md= new MarketData();
    }

    @Given("the user launch the application")
    public void the_user_launch_the_application() {
        la.launchUrl();
    }

    @When("the user go to market data")
    public void theUserGoToMarketData() throws InterruptedException {
       md.goToMarketData();
    }
}
