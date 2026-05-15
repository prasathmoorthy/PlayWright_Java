package factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    static Playwright playwright;
    static Browser browser;
    static Page page;

    public static Page initBrowser() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
        );

        page = browser.newPage();

        page.navigate(
          "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
        );

        return page;
    }

    public static void closeBrowser() {

        browser.close();
        playwright.close();
    }
}