package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
	private Locator userNameLocator;
	private Locator passwordLocator;
	private Locator submitButtonLocator;
	
	public LoginPage(Page page)
	{
		userNameLocator=page.locator("#email1");
		passwordLocator=page.locator("#password1");
		submitButtonLocator=page.locator(".submit-btn");
	}
	
	public void LoginToApplication() {
		userNameLocator.fill("admin@email.com");
		passwordLocator.fill("admin@123");
		submitButtonLocator.click();
	}
	

}
