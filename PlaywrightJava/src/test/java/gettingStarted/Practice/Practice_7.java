package gettingStarted.Practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Practice_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser browser=Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		BrowserContext context=browser.newContext();
		Page page=context.newPage();
		page.navigate("https://letcode.in/window");
		Page newpage=context.waitForPage(()->{
			page.locator("//button[@id='home']").click();
		});
		
		newpage.locator("//a[normalize-space(text())='Tabs']").click();
		String s=newpage.title();
		System.out.println(s);
		page.bringToFront();
		newpage.bringToFront();
		
	}

}
