package gettingStarted;

import java.nio.file.Path;
import java.util.regex.Pattern;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.BrowserType.ConnectOptions;
import com.microsoft.playwright.BrowserType.ConnectOverCDPOptions;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.BrowserType.LaunchPersistentContextOptions;
import com.microsoft.playwright.Page;

public class RegisterNewUser {

	public static void main(String[] args) {
		Browser browser = null;
		Page page= null;
		Playwright pw=null;


		try {
			browser=Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
			page=browser.newPage();
			page.navigate("https://freelance-learn-automation.vercel.app/login");
			page.locator("xpath=//div[@class='content']//a[1]").click();
			PlaywrightAssertions.assertThat(page).hasTitle(Pattern.compile("Learn Automation Courses"));
			System.out.println("Page launched successfully");
		
			
			page.locator("#name").fill(new Faker().name().fullName());
			
			page.locator("#email").fill(new Faker().name().firstName()+"_"+new Faker().name().lastName()+"@gmail.com");
			
			page.locator("#password").fill(new Faker().name().firstName()+"@123");
			
			page.getByText("Java").click();
			
			page.getByText("TestNG").click();
			
			page.locator("xpath=(//div[@class='interest-div']//label)[2]").click();
			
			page.locator("#gender2").click();
			
			page.locator("#gender1").click();
			
			page.locator("#state").selectOption("Tamil Nadu");
			String s[]= {"Playing","Swimming","Dancing"};
			page.locator("#hobbies").selectOption(s);
			
			PlaywrightAssertions.assertThat(page.locator(".submit-btn")).isEnabled();
			System.out.println("Button is enable and all the details are entered Successfully");
			page.locator("xpath=//div[@class='content']//button[1]").click();
			page.waitForTimeout(3000);
			
			PlaywrightAssertions.assertThat(page.getByText("Signup successfully, Please"));
			System.out.println("Signup succesfully");
			
		}
		finally{
			if(pw!=null) {pw.close();}
			if(page!=null) {page.close();}
			if(browser!=null) {browser.close();}
		}
	}

}
