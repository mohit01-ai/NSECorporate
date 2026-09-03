package pageobjects;

import baseclass.BaseClass;
import baseclass.Driverfactory;
import org.openqa.selenium.WebDriver;

public class LaunchApp extends BaseClass {


    public LaunchApp() {
       super();
    }
    public void launchUrl(){
        System.out.println("------------------Application Launched-------------------------");
    }
}
