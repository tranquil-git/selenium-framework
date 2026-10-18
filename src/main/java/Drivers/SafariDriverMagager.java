package Drivers;

import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverMagager extends DriverManager{

    @Override
    public void createWebDriver() {
        this.driver = new SafariDriver();
    }
}