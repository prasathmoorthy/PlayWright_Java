package gettingStarted;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileUploaderWithoutInputTag {

	public static void main(String[] args) {
		Browser browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(750));
		Page page=browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/upload");
		FileChooser fileChooser= page.waitForFileChooser(()-> page.locator("#drag-drop-upload").click());
		Path [] filesUpload= {
				Paths.get("C:\\Eclipse\\PlayWright\\PlaywrightJava\\Files\\Leo badass.jpg"),
				Paths.get("C:\\Eclipse\\PlayWright\\PlaywrightJava\\Files\\Leo badass2.jpg"),
				Paths.get("C:\\Eclipse\\PlayWright\\PlaywrightJava\\Files\\Leo badass3.jpg")
		};
		fileChooser.setFiles(filesUpload);
		}

	}

