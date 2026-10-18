package Base;

import Drivers.DriverFactory;
import Drivers.DriverManager;
import Drivers.DriverManagerFactory;
import Utils.Log;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        Log.info("Start browser: " + browser);
        DriverManager manager = DriverManagerFactory.getManager(browser);
        manager.createWebDriver();
        WebDriver driver = manager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        DriverFactory.setDriverThreadLocal(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            Log.info("Quit browser");
            driver.quit();
            DriverFactory.removeDriver();
        }
    }
}
