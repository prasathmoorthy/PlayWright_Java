package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleAutoSuggestions {

	public static void main(String[] args) {
		Browser browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page=browser.newPage();
		page.navigate("https://www.google.com");
		page.locator(".gLFyf").fill("ms dhoni");
		Locator locator=page.locator("xpath=//ul[@role='listbox' ]//li");
		System.out.println(locator.count());
		for(int i=0;i<locator.count();i++) {
			
			String s=locator.nth(i).innerText();
			System.out.println(s);
			if(s.contains("ms dhoni net worth"))
			{
				locator.nth(i).click();
				break;
			}
			
		}
	}

}
