package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstPlayWrightTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright pw = Playwright.create();
		BrowserType browserType = pw.chromium();
		Browser browser=browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://playwright.dev/java/docs/intro#first-script");
		System.out.println("Titile of Page is -> "+page.title());
		page.close();
		browser.close();
		pw.close();
	}

}
