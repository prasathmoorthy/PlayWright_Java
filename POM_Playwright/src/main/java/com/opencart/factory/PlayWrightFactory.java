package com.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlayWrightFactory {
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	Properties prop;
	
	public Page initBrowser(Properties prop) {
		
		 String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is: " + browserName);
		playwright = Playwright.create();
		switch(browserName.toLowerCase()) {
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		
		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			
		case "chrome":
			browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
			break;
		default:
				System.out.println("Please pass the correct browser name: " + browserName);
				break;
		}
		browserContext = browser.newContext();
		page= browserContext.newPage();
		page.navigate(prop.getProperty("url").trim());
		
		return page;
	}
	
	
	//This method is used to initialize the properties from config file and return the properties object
	public Properties init_Prop() {
		try {
			FileInputStream fis = new FileInputStream("./src/tests/resources/config/config.properties");
			prop = new Properties();
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return prop;
		
	}

}
