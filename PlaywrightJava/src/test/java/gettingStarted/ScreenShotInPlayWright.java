package gettingStarted;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class ScreenShotInPlayWright {
    public static void main(String[] args) {
        Browser browser= Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(750));
        Page page=browser.newPage();
        page.navigate("https://practicetestautomation.com/practice-test-login/");
        byte[] arr=page.screenshot();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("sshot1.png")));
        page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("sshot2.png")));
        page.locator("//h2[normalize-space(text())='Test login']").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("sshot3.png")));
    }
}
