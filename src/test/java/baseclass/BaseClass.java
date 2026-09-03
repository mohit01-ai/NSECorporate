package baseclass;

import org.openqa.selenium.WebDriver;

public class BaseClass {
  protected WebDriver driver;

    public BaseClass(){
        this.driver = Driverfactory.getDriver();
    }

}
