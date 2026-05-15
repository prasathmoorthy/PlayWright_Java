package gettingStarted;

import java.nio.file.Path;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileUploader {

	public static void main(String[] args) {
		Browser browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(750));
		Page page=browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/upload");
		//page.locator("#file-upload").setInputFiles(Path.of("C:\\Eclipse\\PlayWright\\PlaywrightJava\\Files\\Leo badass.jpg"));
//------------------------------------------
		Path files[]= {Path.of(System.getProperty("user.dir")+"/Files/Leo badass.jpg")};
//		page.locator("#file-upload").setInputFiles(files);
		page.locator("#file-upload").setInputFiles(files[0]);
		page.waitForTimeout(3000);
		page.locator("#file-upload").setInputFiles(new Path[0]);

	}

}
