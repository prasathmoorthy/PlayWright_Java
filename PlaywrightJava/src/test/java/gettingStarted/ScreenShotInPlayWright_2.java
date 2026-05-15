package gettingStarted;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class ScreenShotInPlayWright_2 {
    public static void main(String[] args) {
        Browser browser= Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(750));
        Page page=browser.newPage();
        page.navigate("https://practicetestautomation.com/practice-test-login/");
        page.locator("//h2[normalize-space(text())='Test login']");
        UtilitySS.captureScreenShot(page);
    }
}
