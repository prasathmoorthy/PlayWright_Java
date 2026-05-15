package pageObjectModelTest;

import java.nio.file.Path;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.ConnectOptions;
import com.microsoft.playwright.BrowserType.ConnectOverCDPOptions;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.BrowserType.LaunchPersistentContextOptions;

import pages.LoginPage;

import com.microsoft.playwright.Page;

public class TestUsingPOM {
	@Test
	 public void login() {
		Browser browser= Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(3000));
		Page page=browser.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		LoginPage loginPage=new LoginPage(page);
		loginPage.LoginToApplication();
	}

}
