package gettingStarted;

import com.microsoft.playwright.*;

public class HandleShadow {
	public static void main(String[] args) {
		Browser browser= Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(750));
		Page page=browser.newPage();
		page.navigate("https://letcode.in/shadow");
		page.locator("#open-shadow #fname").fill("Ramyaa");

		
	}
}
