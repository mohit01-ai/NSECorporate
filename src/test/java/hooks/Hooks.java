package hooks;

import baseclass.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
        Driverfactory.initDriver();
    }

    @After
    public void teardown() {
        Driverfactory.quitDriver();
    }
}
