package gettingStarted.Actian;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Practice2 {

	@Test
	public void setUp() {
		// TODO Auto-generated method stub
		Browser browser= Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        page.navigate("https://www.google.com/");
        assertEquals(page.title(), "Google");
        System.out.println(page.title());
	}

}
