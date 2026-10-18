package Tests;

import Base.BaseTest;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Login thanh cong voi user hop le")
    public void test_valid_login() {
        new LoginPage(getDriver()).open().login("standard_user", "secret_sauce");
        Assert.assertEquals(new InventoryPage(getDriver()).getTitle(), "Products");
    }

    @Test(description = "Login sai password hien thi thong bao loi")
    public void test_invalid_password() {
        LoginPage loginPage = new LoginPage(getDriver()).open();
        loginPage.login("standard_user", "wrong_password");
        Assert.assertTrue(loginPage.getErrorMessage()
                .contains("Username and password do not match"));
    }

    @Test(description = "Login voi user bi khoa")
    public void test_locked_out_user() {
        LoginPage loginPage = new LoginPage(getDriver()).open();
        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertTrue(loginPage.getErrorMessage().contains("locked out"));
    }

    // Test co tinh FAIL de demo log + report + screenshot khi fail. Xoa khi khong can.
    @Test(description = "DEMO FAIL: kiem tra title sai de chup screenshot")
    public void test_demo_fail_screenshot() {
        new LoginPage(getDriver()).open().login("standard_user", "secret_sauce");
        Assert.assertEquals(new InventoryPage(getDriver()).getTitle(), "Wrong Title");
    }
}
