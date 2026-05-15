package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class KeyBoardDemo {
    public static void main(String[] args) {
        Browser browser= Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1700));
        Page page=browser.newPage();
        page.navigate("https://practicetestautomation.com/practice-test-login/");
        page.locator("#username").fill("student");
        page.keyboard().press("Control+A");
        page.keyboard().press("Control+C");
        page.keyboard().press("Tab");
        page.keyboard().press("Control+V");
        page.keyboard().press("Tab");
        page.keyboard().press("Enter");
    }
}
