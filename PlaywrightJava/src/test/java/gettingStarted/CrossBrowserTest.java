package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.apache.commons.lang3.SystemUtils;
import org.testng.annotations.*;

public class CrossBrowserTest {

	Playwright pw;
	Browser browser;
	Page page;

	@Parameters("BrowserName")
	@BeforeMethod
	public void setup(@Optional("Chrome") String browserName) {
		pw=Playwright.create();
		BrowserType browserType=null;
		if(browserName.equalsIgnoreCase("chrome")){
			browserType= pw.chromium();
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			browserType= pw.firefox();
		}
		else if(browserName.equalsIgnoreCase("Safari")){
			browserType= pw.webkit();
		};

		browser=browserType.launch(new BrowserType.LaunchOptions()
				.setHeadless(false)
				.setSlowMo(3000));
		page=browser.newPage();
	}

	@AfterMethod
	public void tearDown(){

		page.close();
		browser.close();
		pw.close();
	}
	
	
	@Test
	public void loginTest() throws InterruptedException {
		 page.navigate("https://freelance-learn-automation.vercel.app/login");
		 System.out.println(page.title());
		 Thread.sleep(5000);
	}

}
