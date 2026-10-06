package hooks;

import baseclass.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;


public class Hooks {

    @Before
    public void setup() {
        Driverfactory.initDriver();
    }

    @After
    public void teardown() {
        Driverfactory.quitDriver();
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        TakesScreenshot screenshot = (TakesScreenshot) Driverfactory.getDriver();
        byte[] shot = screenshot.getScreenshotAs(OutputType.BYTES);

        if (scenario.isFailed()) {
            scenario.attach(shot, "image/png", "FailedScreenshot");
        }
    }
}
