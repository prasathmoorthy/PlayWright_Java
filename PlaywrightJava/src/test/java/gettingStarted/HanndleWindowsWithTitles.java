package gettingStarted;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HanndleWindowsWithTitles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser browser=Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(750));
		BrowserContext context=browser.newContext();
		Page page=context.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		Locator allLinks=page.locator("//div[@class='social']//a");
		for(int i=0;i<allLinks.count();i++)
		{
			allLinks.nth(i).click();
		}
		List<Page> allPages=context.pages();
		for(Page p:allPages)
		{
			String title=p.title();
			if(title.contains("YouTube"))
			{
				p.bringToFront();
				p.getByPlaceholder("Search").fill("TVK");
				break;
			}
		}
		page.bringToFront();
		
	}

}
