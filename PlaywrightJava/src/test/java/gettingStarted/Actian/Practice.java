package gettingStarted.Actian;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;


public class Practice {
	
	/*
    @org.testng.annotations.Test
    public void Setup()
    {
        Browser browser= Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page=browser.newPage();
        page.navigate("https://www.google.com/");
        page.locator("//textarea[@aria-label='Search']").fill("bigfix software");
        page.keyboard().press("Enter");
        page.waitForTimeout(15000);
        page.locator("//h3[contains(.,'Endpoint')]").click();
        page.waitForTimeout(15000);
		page.locator("//li/a[contains(text(),'Use Cases')][contains(@class,'menu')]").hover();
		page.waitForTimeout(5000);
		page.locator("(//a//div[@class='dropdown-menu-title'])[position()=21]").click();
		System.out.println(page.url());
		page.waitForTimeout(15000);
		
    }
    */
	@org.testng.annotations.Test
	public void windows() {
		// Use try-with-resources to ensure Playwright is closed
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions()
							.setHeadless(false)
							.setSlowMo(750));
			BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1280, 800));
			Page page = context.newPage();
			page.navigate("https://letcode.in/window");
			System.out.println(page.title());

			// Wait for the new page (popup) to be created by the click
			Page newPage = context.waitForPage(() -> {
				page.locator("#home").click();
			});

			// Wait until the new page finishes loading, then bring to front and explicitly focus
			newPage.waitForLoadState();
			newPage.bringToFront();
			// Some OSes prevent programmatic focus; also call window.focus in page context
			newPage.evaluate("() => window.focus()");
			newPage.waitForTimeout(2000);

			System.out.println("New page title ->" + newPage.title());
			System.out.println("New page url ->" + newPage.url());

			// If you still need to toggle back to original page
			page.bringToFront();
			page.waitForTimeout(1000); 
			page.screenshot(new ScreenshotOptions().setPath(Paths.get("./Screenshots/screenShot_"+System.currentTimeMillis()+".png")));
			SimpleDateFormat sdf=new SimpleDateFormat("yyyymmdd_hhmmss");
			String date=sdf.format(new Date());
			newPage.screenshot(new ScreenshotOptions().setPath(Paths.get("./Screenshots/screenShot_"+date+".png")));
			
		}
	}
}
