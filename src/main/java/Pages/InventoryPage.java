package Pages;

import Base.BasePage;
import Constants.TimeOutConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    //locator
    private final By lblTitle = By.cssSelector("[data-test='title']");
    private final By lblCartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    private final By lnkCart = By.cssSelector("[data-test='shopping-cart-link']");

    public InventoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTitle() {
        return getText(lblTitle, TimeOutConstants.TIME_OUT_DEFAULT);
    }

    // productId vd: "sauce-labs-backpack"
    public void addToCart(String productId) {
        click(By.id("add-to-cart-" + productId));
    }

    public String getCartBadgeCount() {
        return getText(lblCartBadge, TimeOutConstants.TIME_OUT_DEFAULT);
    }

    public CartPage openCart() {
        click(lnkCart);
        return new CartPage(driver);
    }
}
