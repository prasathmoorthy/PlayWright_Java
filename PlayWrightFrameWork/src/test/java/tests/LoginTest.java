package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ExcelUtil;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        LoginPage loginPage =
                new LoginPage(getPage());

        DashboardPage dashboardPage =
                new DashboardPage(getPage());

        String username =
                ExcelUtil.getCellData("Login",1,0);

        String password =
                ExcelUtil.getCellData(
                        "Login",
                        1,
                        1);

        loginPage.login(username, password);

        Assert.assertTrue(
                dashboardPage.isDashboardVisible()
        );
    }
}