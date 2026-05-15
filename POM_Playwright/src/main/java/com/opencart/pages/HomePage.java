package com.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;
	//1. String locators: By, String, ElementUtil
	private String search = "input[name='search']";
	private String searchIcon = "button[class='btn btn-default btn-lg']";
	private String searchPageHeader = "div#content h1";
	private String loginLink = "//a[normalize-space(text())='Login']";
	private String MyaccountLink="//span[normalize-space(text())='My Account']";
	
	
	//2. page Constructor
	public HomePage(Page page) {
		this.page = page;
	}
	
	//3. page actions: page title, page header, do search
	
	public String getHomePageTitle() {
		System.out.println("Home page title is: " + page.title());
		return page.title();
	}
	
	public String getHomePageUrl() {
		System.out.println("Home page url is: " + page.url());
		return page.url();
	}
	public String doSearch(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
		System.out.println("Search page header is: " + page.textContent(searchPageHeader));
		return page.textContent(searchPageHeader);
		
	}
	
	public LoginPage navigateToLoginPage() {
		page.click(MyaccountLink);
		page.click(loginLink);
		return new LoginPage(page);
	}
	
}
