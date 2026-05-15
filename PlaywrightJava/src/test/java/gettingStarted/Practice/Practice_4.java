package gettingStarted.Practice;

import java.nio.file.Path;
import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.BrowserType.ConnectOptions;
import com.microsoft.playwright.BrowserType.ConnectOverCDPOptions;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.BrowserType.LaunchPersistentContextOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Practice_4 {
	public static void main(String args[]) {
		Browser browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(750));
		Page page=browser.newPage();
		page.navigate("https://www.google.com");
		page.locator("#APjFqb").fill("amazon");
		Locator locator=page.locator("xpath=(//ul[@role='listbox'])//li");
		System.out.println(locator.count());
		
		for(int i=0;i<locator.count();i++) {
			String s=locator.nth(i).innerText();
			System.out.println(s);
		}
		locator.nth(0).click();
		page.waitForTimeout(20000);
		PlaywrightAssertions.assertThat(page.locator("xpath=(//span[contains(@class,'OSrXXb VN4UC')]//span)[1]")).containsText("amazon.in");
		System.out.println("success");
		page.locator("xpath=(//span[contains(@class,'OSrXXb VN4UC')]//span)[1]").click();
		page.locator("#twotabsearchtextbox").fill("iphone");
		Locator locator_2=page.locator("xpath=//div[@role='rowgroup']");
		String s2=locator_2.innerText();
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(s2);
		page.waitForTimeout(30000);
		
		
		page.close();
		browser.close();
		
		
		
	}

}
