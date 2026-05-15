package com.opencart.base;

import java.security.ProtectionDomain;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Page;
import com.opencart.factory.PlayWrightFactory;
import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;

public class BaseTest {
	PlayWrightFactory pwf;
	protected HomePage homePage;
	protected Page page;
	protected Properties prop;
	protected LoginPage loginPage;
	
	
	
	@BeforeMethod
	public void homePageSetUp() {
		pwf = new PlayWrightFactory();
		prop = pwf.init_Prop();
		page=pwf.initBrowser(prop);
		homePage = new HomePage(page);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		page.context().browser().close();
		
	}

}
