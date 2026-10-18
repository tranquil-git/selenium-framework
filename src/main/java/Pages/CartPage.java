package Pages;

import Base.BasePage;
import Constants.TimeOutConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    //locator
    private final By lblItemName = By.cssSelector("[data-test='inventory-item-name']");

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getItemNames() {
        waitForElementVisible(lblItemName, TimeOutConstants.TIME_OUT_DEFAULT);
        return driver.findElements(lblItemName).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
