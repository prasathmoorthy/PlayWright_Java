package gettingStarted.Practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import gettingStarted.UtilitySS;

public class Practice_9 {
    public static void main(String[] args){
        Browser browser= Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(750));
        Page page=browser.newPage();
        page.navigate("https://freelance-learn-automation.vercel.app/login");
        String selector= "//div[@class='content']//input[1]";
        UtilitySS.CaptureElementScreenShot(page,selector);
    }
}
