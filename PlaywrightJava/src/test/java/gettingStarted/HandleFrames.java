package gettingStarted;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser browser=Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(750));
		Page page=browser.newPage();
		page.navigate("https://www.redbus.in/");
		page.locator("//button[@class='navOption___585d46']").last().click();
		page.locator("//button[@class='primaryButton___5380e6  ']").click();
		List<Frame> allFrames=page.frames();
		for(Frame p:allFrames)
		{
			System.out.println(p);
		}
		System.out.println(allFrames.size());
		page.locator("//label[text()='Mobile number']/following::input").fill("9874563210");
		
		
	}

}
