package baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class Driverfactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<String> browserName = new ThreadLocal<>();
    public static Properties prop;

    public static ThreadLocal<String> getBrowser() {
        return browserName;
    }

    public static void setBrowser(String browser) {
        browserName.set(browser);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver() {
        String browser = browserName.get();
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            prop = new Properties();
            prop.load(file);
            boolean headless = Boolean.parseBoolean(prop.getProperty("headless", "true"));
            String executionEnv = prop.getProperty("exeEnv");

            if (executionEnv.equalsIgnoreCase("local")) {
                if (browser.equalsIgnoreCase("chrome")) {
                    ChromeOptions options = new ChromeOptions();
                    if (headless) {
                        options.addArguments("--headless=new");
                    }
                    driver.set(new ChromeDriver(options));


                } else if (browser.equalsIgnoreCase("firefox")) {
                    FirefoxOptions options = new FirefoxOptions();
                    if (headless) {
                        options.addArguments("-headless");
                    }
                    driver.set(new FirefoxDriver(options));
                } else if (browser.equalsIgnoreCase("edge")) {
                    EdgeOptions options = new EdgeOptions();
                    if (headless) options.addArguments("--headless=new");
                    driver.set(new EdgeDriver(options));
                } else {
                    throw new IllegalArgumentException("browser not valid");
                }
            } else if (executionEnv.equalsIgnoreCase("remote")) {
                URL gridUrl = new URL("http://localhost:4444");

                if (browser.equalsIgnoreCase("chrome")) {
                    ChromeOptions options = new ChromeOptions();
                    if (headless) {
                        options.addArguments("--headless=new");
                    }
                    driver.set(new RemoteWebDriver(gridUrl, options));


                } else if (browser.equalsIgnoreCase("firefox")) {
                    FirefoxOptions options = new FirefoxOptions();
                    if (headless) {
                        options.addArguments("-headless");
                    }
                    driver.set(new RemoteWebDriver(gridUrl, options));
                } else if (browser.equalsIgnoreCase("edge")) {
                    EdgeOptions options = new EdgeOptions();
                    if (headless) options.addArguments("--headless=new");
                    driver.set(new RemoteWebDriver(gridUrl, options));
                } else {
                    throw new IllegalArgumentException("browser not valid");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        driver.get().get(prop.getProperty("URL"));
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

public static void quitDriver(){
        if(driver.get()!=null){
            driver.get().quit();
            driver.remove();
        }
}
}
