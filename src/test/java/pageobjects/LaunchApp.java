package pageobjects;

import org.openqa.selenium.WebDriver;

public class LaunchApp {
WebDriver driver;

    public LaunchApp(WebDriver driver) {
      this.driver = driver;
    }
    public void launchUrl(){
        System.out.println("------------------Application Launched-------------------------");
    }
}
