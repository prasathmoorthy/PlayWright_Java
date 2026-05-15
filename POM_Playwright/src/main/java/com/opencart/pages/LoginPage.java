package com.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;
	
	//1. String locators: 
	private String emailId = "//input[@placeholder='E-Mail Address']";
	private String password = "//input[@placeholder='Password']";
	private String loginBtn = "//input[@class='btn btn-primary']";
	private String forgotPwdLink = "//input[@name='password']/following-sibling::a[1]";
	private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";
	
	//2. page Constructor
		 public LoginPage(Page page) {
			this.page = page;
		}
		
		 //3. page actions:
		 
		 public String getLoginPageTitle() {
			return page.title();
		}
		 
		 public Boolean isForgotPasswordLinkExist() {
			  return page.isVisible(forgotPwdLink);
		}
		 
		 public Boolean doLogin(String username, String pwd) {
			 page.fill(emailId, username);
			 page.fill(password, pwd);
			 page.click(loginBtn);
			 if(page.isVisible(logoutLink)) {
				 System.out.println("Login is successful");
				 return true;
			 }
			 return false;
			
		}
}
