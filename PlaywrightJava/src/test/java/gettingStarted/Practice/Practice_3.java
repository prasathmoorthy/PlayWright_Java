package gettingStarted.Practice;

import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Practice_3 {
	private void PositiveLoginTest(Page page) {
		// TODO Auto-generated method stub
		PlaywrightAssertions.assertThat(page).hasTitle("Test Login | Practice Test Automation");
		System.out.println("Page launched successfully");
		

		//Login
		page.locator("#username").fill("student");
		page.locator("xpath=//*[@id=\"password\"]").fill("Password123");
		page.locator(".btn").click();
		

		//Verify the page
		//PlaywrightAssertions.assertThat(page).hasURL("https://practicetestautomation.com/logged-in-successfully/");
		PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("logged-in-successfully"));
		System.out.println("Login succesfull");

		//Logout
		page.locator("xpath=//a[normalize-space(text())='Log out']").click();

		//Verify logout
		PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("practice-test-login"));
		System.out.println("Logout Successfully");
	}
	
	//--------------------------MAIN CLASS----------------------------------------------------------
	
	public static void main(String[] args) {
		Playwright pw=null;
		Browser browser =null;
		Page page=null;
		try {
			browser=Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1750));
			page=browser.newPage();
			page.navigate("https://practicetestautomation.com/practice-test-login/");
			page.waitForTimeout(2000);
			//-----------------------------CREATING OBJECT------------------------------------------------------
			Practice_3 obj=new Practice_3();
			//------------------------------DEFINING METHODS
			obj.PositiveLoginTest(page);
		} finally {
			if(pw!=null) {pw.close();}
			if(page!=null) {page.close();}
			if(browser!=null) {browser.close();}
		}
		
	}
	

}
