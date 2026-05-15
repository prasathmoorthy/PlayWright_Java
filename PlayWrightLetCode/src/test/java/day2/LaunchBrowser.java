package day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowser {
	
	public static void main(String args[]) {
		
		
		
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions()
				.setHeadless(false)
				.setChannel("msedge"));
		Page page = browser.newPage();
		page.navigate("https://www.cricbuzz.com/");
		String title=page.title();
		System.out.println("Page Title : "+title);
		
		
		
		page.close();
		browser.close();
		playwright.close();
	}

}
