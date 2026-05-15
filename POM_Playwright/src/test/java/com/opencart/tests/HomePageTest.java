package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.base.BaseTest;
import com.opencart.constant.AppConstants;

public class HomePageTest extends BaseTest {
	
	
	
	

	
	@Test
	public void homePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is: " + title);
		Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);
	}
	
	@Test
	public void homePageUrl() {
		String Url = homePage.getHomePageUrl();
		System.out.println("Home page Url is: " + Url);
		Assert.assertEquals(Url, prop.getProperty("url").trim());
	}
	
	@Test(dataProvider = "getProductData")
	public void SearchTest(String productName) {
		String actualSearchHeaderString= homePage.doSearch(productName);
		Assert.assertEquals(actualSearchHeaderString, "Search - " + productName);
	}
	
	@DataProvider
	public Object [][] getProductData() {
		return new Object[][] {
			{"MacBook"},
			{"iMac"},
			{"Samsung"},
			{"Apple"},
			{"HP"}	
		};
	}	
	
	
}
