package gettingStarted;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class storageStage {
    public static void main(String[] args) {
        Browser browser = Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(750));
        BrowserContext context = browser.newContext();;
        Page page = context.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/");
        page.locator("input[name='username']").fill("Admin");
        page.locator("input[name='password']").fill("admin123");
        page.click("button[type='submit']");

        page.waitForURL("**/dashboard/index");
        context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("./Auth/auth.json")));

        browser.close();

    }
}
