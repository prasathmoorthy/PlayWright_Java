package gettingStarted;

import com.microsoft.playwright.*;

public class HandleSSLCertificate {
    public static void main(String[] args){
        Browser browser= Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Browser.NewContextOptions contextOptions=new Browser.NewContextOptions();
        contextOptions.setIgnoreHTTPSErrors(true);
        BrowserContext context=browser.newContext(contextOptions);
        Page page=context.newPage();
        page.navigate("https://expired.badssl.com/");

    }
}
