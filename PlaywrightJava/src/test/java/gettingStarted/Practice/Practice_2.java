package gettingStarted.Practice;

import java.nio.file.Path;
import java.util.regex.Pattern;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.BrowserType.ConnectOptions;
import com.microsoft.playwright.BrowserType.ConnectOverCDPOptions;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.BrowserType.LaunchPersistentContextOptions;

public class Practice_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright pw= null;
		Browser browser=null;
		Page page=null;
		try {
			
			browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			page=browser.newPage();
			page.navigate("https://www.cricbuzz.com/");
			PlaywrightAssertions.assertThat(page).hasTitle("Women's Premier League 2026 | Live Cricket Score, Schedule, Latest News, Stats &amp; Videos | Cricbuzz.com");
//			Assert.assertTrue(page.title().contains("Google"));
			System.out.println("Page launched successfully");
			System.out.println("------------------------------------");
			
			page.locator("xpath=//span[normalize-space(text())='India won by 4 wkts']").click();
			page.waitForTimeout(5000);
			PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("2026"));
			System.out.println("Page verified");
			page.locator("xpath=//span[normalize-space(text())='Virat Kohli']").click();
			page.waitForTimeout(5000);
			String cc=page.locator("xpath=(//div[text()='Batting Style']/following-sibling::div)[2]").textContent();
			System.out.println(cc);
			System.out.println("----------------------------------");
			PlaywrightAssertions.assertThat(page.locator("xpath=(//div[text()='Born']/following-sibling::div)[2]")).containsText("November");
			System.out.println("Verified born age");
			page.waitForTimeout(3000);
		} finally {
			if (page != null) page.close();
			if (browser != null) browser.close();
			if (pw != null) pw.close();
		}

	}

}
