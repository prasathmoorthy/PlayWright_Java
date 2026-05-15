package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HanndleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser browser=Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(750));
		BrowserContext context=browser.newContext();
		Page page=context.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		Page newpage=context.waitForPage(()->{
			page.locator("xpath=//a[contains(@href,'youtube')]").first().click();
		});
		
		newpage.locator("//input[@name='search_query']").fill("TVK");
		newpage.locator("(//span[@class='yt-icon-shape ytSpecIconShapeHost']//div)[1]").click();
		newpage.waitForTimeout(2000);
		
		page.bringToFront();
		newpage.bringToFront();
		page.bringToFront();
		newpage.bringToFront();
		
	}

}
