package gettingStarted;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class ReuseStorageState {
    public static void main(String args[]) {
        Browser browser=Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(750));
        BrowserContext context= browser.newContext(new Browser.NewContextOptions()
                .setStorageStatePath((Paths.get("./Auth/auth.json"))));
        Page page=context.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        page.waitForTimeout(2000);
        browser.close();

    }
}
