package gettingStarted.Practice;

import java.nio.file.Path;
import java.util.List;

import javax.naming.Context;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.ConnectOptions;
import com.microsoft.playwright.BrowserType.ConnectOverCDPOptions;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.BrowserType.LaunchPersistentContextOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Practice_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(850));

		// Create context with video recording using utility class
		BrowserContext context = UtilityVideoRec.CaptureVideo(browser);

		Page page = context.newPage();
		page.navigate("https://testgrid.io/blog/window-handling-in-selenium/");

		Locator allLinks = page.locator("//div[@class='llm-sharing-wrapper']//a");

		for(int i = 0; i < allLinks.count(); i++)
		{
			allLinks.nth(i).click();
		}

		page.bringToFront();

		List<Page> allPages = context.pages();

		for(Page p : allPages)
		{
			String title = p.title();
			if(title.contains("Claude"))
			{
				p.bringToFront();
				System.out.println(p.title());
				break;
			}
		}

		page.close();
		context.close();
		browser.close();
	}

}