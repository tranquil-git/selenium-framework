package Pages;

import Base.BasePage;
import Constants.TimeOutConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public static final String URL = "https://www.saucedemo.com/";

    //locator
    private final By txtUsername = By.id("user-name");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.id("login-button");
    private final By lblError = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage open() {
        driver.get(URL);
        return this;
    }

    public void login(String username, String password) {
        inputText(txtUsername, username);
        inputText(txtPassword, password);
        click(btnLogin);
    }

    public String getErrorMessage() {
        return getText(lblError, TimeOutConstants.TIME_OUT_DEFAULT);
    }
}
