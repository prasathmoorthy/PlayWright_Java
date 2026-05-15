package gettingStarted;

import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class LoginLogoutTestNG {

	@Test
	public void loginTest() {
		// TODO Auto-generated method stub
		Playwright pw=null;
		Browser browser = null;
		Page page = null;
		try {
			browser= Playwright.create().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			page=browser.newPage();
			page.navigate("https://practicetestautomation.com/practice-test-login/");
			//PlaywrightAssertions.assertThat(page).hasTitle("Test Login | Practice Test Automation");
			
			//TestNG assertion
			Assert.assertTrue(page.title().contains("Test Login | Practice Test Automation"));
			//page.wait(3000);
			System.out.println("Page launched successfully");
			page.waitForTimeout(3000);

			//Login
			page.locator("#username").fill("student");
			page.locator("xpath=//*[@id=\"password\"]").fill("Password123");
			page.locator(".btn").click();
			page.waitForTimeout(2000);

			//Verify the page
			//PlaywrightAssertions.assertThat(page).hasURL("https://practicetestautomation.com/logged-in-successfully/");
			//PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("logged-in-successfully"));
			Assert.assertTrue(page.url().contains("logged-in-successfully"));
			System.out.println("Login succesfull");
			page.waitForTimeout(2000);

			//Logout
			page.locator("xpath=//a[normalize-space(text())='Log out']").click();

			//Verify logout
			PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("practice-test-login"));
			System.out.println("Logout Successfully");
		} 
		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		finally {
			if (page != null) page.close();
			if (browser != null) browser.close();
			if (pw != null) pw.close(); 
		}
	}

}
