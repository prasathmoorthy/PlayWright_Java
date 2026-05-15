
package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage(page);
        DashboardPage dashboardPage = new DashboardPage(page);

        loginPage.clickLogin();
        loginPage.login("test@email.com", "123456");

        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Login failed");
    }
}
