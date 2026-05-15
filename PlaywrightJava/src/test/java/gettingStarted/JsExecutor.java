package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JsExecutor {
    public static void main(String[] args) {
        Browser browser= Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(750));
        Page page=browser.newPage();
        page.navigate("https://login.yahoo.com/");
        page.evaluate("document.getElementById('persistent').click()");


    }
}
