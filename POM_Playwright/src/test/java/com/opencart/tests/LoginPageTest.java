package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.base.BaseTest;
import com.opencart.constant.AppConstants;

public class LoginPageTest extends BaseTest {
	
	//1. test data: username, password
	//2. before method: login page object
	//3. test methods: login page title, forgot pwd link, do login
	@BeforeMethod
	public void navigateToLogin() {
		// ensure each test gets a fresh LoginPage backed by a live Playwright Page
		loginPage = homePage.navigateToLoginPage();
	}

	@Test(priority=1)
	public void loginPageNavigationTest() {
		String actualLoginTitileString = loginPage.getLoginPageTitle();
		System.out.println("Login page title is: " + actualLoginTitileString);
		Assert.assertEquals(actualLoginTitileString, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void forgotPasswordLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}
	
	@Test(priority=3)
	public void doLoginTest() {
	Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
	}

}
