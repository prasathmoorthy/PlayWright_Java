package gettingStarted;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class HandleAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(800));
		Page page=browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		//page.locator("//button[normalize-space(text())='Click for JS Alert']").click();
		page.pause();
		page.onceDialog(dialog->{
			String msg=dialog.message();
			System.out.println(msg);
			Assert.assertTrue(msg.contains("I am a JS Confirm"));
			dialog.accept();
		});
		page.locator("//button[normalize-space(text())='Click for JS Confirm']").click();
	}

}
