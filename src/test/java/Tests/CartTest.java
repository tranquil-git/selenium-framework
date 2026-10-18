package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CartTest extends BaseTest {

    @Test(description = "Them 2 san pham vao gio, kiem tra badge va gio hang")
    public void test_add_products_to_cart() {
        new LoginPage(getDriver()).open().login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.addToCart("sauce-labs-backpack");
        inventoryPage.addToCart("sauce-labs-bike-light");
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "2");

        CartPage cartPage = inventoryPage.openCart();
        List<String> items = cartPage.getItemNames();
        Assert.assertEquals(items.size(), 2);
        Assert.assertTrue(items.contains("Sauce Labs Backpack"));
        Assert.assertTrue(items.contains("Sauce Labs Bike Light"));
    }
}
