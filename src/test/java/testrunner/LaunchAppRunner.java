package testrunner;

import baseclass.Driverfactory;
import com.beust.jcommander.Parameter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        tags ="@launch",
        features = "src/test/resources/features",
        glue = {"stepdefinitions","hooks"},
        plugin ={"pretty"},
        monochrome = true
)
public class LaunchAppRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters("browser")
    public void setBrowser(String browser){
         Driverfactory.setBrowser(browser);
    }
}
