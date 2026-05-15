package gettingStarted.Practice;

import static org.testng.Assert.assertTrue;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import junit.framework.Assert;

public class Practice_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser browser=Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		Page page=browser.newPage();
		page.navigate("https://letcode.in/alert");
//		
//		page.onDialog(dialog->{
//			String msg=dialog.message();
//			System.out.println(msg);
//			Assert.assertTrue(msg.contains("Are you happy with LetCode?"));
//			dialog.accept();
//		});
//		page.locator("//button[normalize-space(text())='Confirm Alert']").click();
		
		page.onDialog(dialog->{
			String msg2=dialog.message();
			System.out.println(msg2);
			Assert.assertTrue(msg2.contains("Enter your name"));
			dialog.accept("I hate myself");
		});
		page.locator("//button[normalize-space(text())='Prompt Alert']").click();
	}

}
