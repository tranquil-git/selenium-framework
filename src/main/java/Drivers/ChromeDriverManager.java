package Drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class ChromeDriverManager extends DriverManager {
    @Override
    public void createWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // tat automation bar
        options.setExperimentalOption("useAutomationExtension", false);             // tat automation bar

        // Disable password save dialog
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // chay headless: -Dheadless=true
        if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
            options.addArguments("--headless=new", "--window-size=1920,1080");
        }

        this.driver = new ChromeDriver(options);
    }
}
