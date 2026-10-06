package stepdefinitions;

import baseclass.Driverfactory;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.HomePage;

import java.util.List;

public class HomePageStepDefinition {
    WebDriver driver;
    HomePage home;

    public HomePageStepDefinition() {
        driver = Driverfactory.getDriver();
        home = new HomePage(driver);


    }

    @When("user click on home icon")
    public void userClickOnHomeIcon() {
        home.clickHomeIcon();
    }

    @Then("verify all the indexes are available on the home page")
    public void verifyAllTheIndexesAreAvailableOnTheHomePage() {
        home.getIndexNames();
    }


    @Then("Verify the index names are appearing correctly")
    public void verifyTheIndexNamesAreAppearingCorrectly(List<String> names) {
            home.verifyIndexNames(names);

    }

    @When("the user get all index names list")
    public void theUserGetAllIndexNamesList() {
        home.getIndexNames();
    }
}
