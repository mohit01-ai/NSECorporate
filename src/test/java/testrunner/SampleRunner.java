package testrunner;

import baseclass.Driverfactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

@CucumberOptions(
        tags = "@verifyIndexNames",
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)
public class SampleRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters("browser")
    public void setBrowser(String browser) {
        Driverfactory.setBrowser(browser);
    }
}
