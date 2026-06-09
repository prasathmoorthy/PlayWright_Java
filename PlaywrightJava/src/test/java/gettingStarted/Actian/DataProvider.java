package gettingStarted.Actian;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.errorprone.annotations.InlineMeValidationDisabled;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class DataProvider {
	
	@Test(dataProvider="TestData")
	public void testing(String country, String result) {
		
	
	Browser browser= Playwright.create()
			.firefox()
			.launch(new BrowserType.LaunchOptions()
					.setHeadless(false)
					.setSlowMo(750));
	Page page=browser.newPage();
	page.navigate("https://en.wikipedia.org/wiki/Main_Page");
	page.locator("(//input[@name='search'])[1]").fill(country);
	page.locator("(//button[contains(@class,'cdx-button cdx-button--action-default')])[1]").click();
	page.waitForTimeout(2000);
	PlaywrightAssertions.assertThat(page
			.locator("(//h1[@class='firstHeading mw-first-heading']//span)[2]"))
			.hasText(result);
	
	}
	
	
	@org.testng.annotations.DataProvider(name="TestData")
	public Object[][] getData() {
		Object[][] data= new Object[][] {
				{"US","United States"},
				{"India","India"},
				{"UK","United Kingdom"},
				{"Germany","Germany"}
		};
		return data;
		
	}

}
