package Drivers;

public class DriverManagerFactory {

    public static DriverManager getManager(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                return new FirefoxDriverManager();
            case "edge":
                return new EdgeDriverManager();
            case "safari":
                return new SafariDriverMagager();
            case "chrome":
            default:
                return new ChromeDriverManager();
        }
    }
}
