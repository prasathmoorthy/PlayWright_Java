package gettingStarted;

import java.util.regex.Pattern;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class VerifyTextMessage {

	public static void main(String[] args) {
		Browser browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(750));
		Page page=browser.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		page.locator(".submit-btn").click();
//		String actual=page.locator(".errorMessage").innerText();
//		String exp="Email and Password is required";
//		Assert.assertEquals(exp, actual);
		
		PlaywrightAssertions.assertThat(page.locator(".errorMessage")).containsText("Email and Password is required");
		PlaywrightAssertions.assertThat(page.locator(".errorMessage")).containsText(Pattern.compile("Email"));
		//PlaywrightAssertions.assertThat(page.locator(".errorMessage")).
		browser.close();
		page.close();
		
		
	}
 
}
