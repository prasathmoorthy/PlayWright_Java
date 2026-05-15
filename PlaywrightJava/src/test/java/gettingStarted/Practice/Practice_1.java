package gettingStarted.Practice;

import java.nio.file.Path;
import java.util.Scanner;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.ConnectOptions;
import com.microsoft.playwright.BrowserType.ConnectOverCDPOptions;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.BrowserType.LaunchPersistentContextOptions;
import com.microsoft.playwright.Page;

public class Practice_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		Playwright pw= Playwright.create();
		BrowserType browsertype=pw.chromium();
		//BrowserType browsertype=pw.firefox();
		//BrowserType browsertype=pw.webkit();
		Browser browser=browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		Page page=browser.newPage();
		page.navigate(s);
		System.out.println("Page Titileis -> "+page.title());
		page.close();
		browser.close();
		pw.close();
	}

}
