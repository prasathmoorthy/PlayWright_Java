package gettingStarted.Assignment;

import java.nio.file.Path;
import java.util.regex.Pattern;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser browser = null;
		Page page= null;
		Playwright pw=null;
		
		try {
			browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1150));
			page=browser.newPage();
			page.navigate("https://freelance-learn-automation.vercel.app/login");
	//		PlaywrightAssertions.assertThat(page).hasTitle(Pattern.compile("Learn Automation Courses"));
			Assert.assertTrue(page.title().contains("Courses"));
			System.out.println("Title verified");
			Assert.assertTrue(page.locator("xpath=//a[contains(@href,'youtube')]").first().isVisible());
			System.out.println("Youtube icon verified");
			//---------------------------------------------Assignment 1---------------------------------------
			
			page.locator("#email1").fill("admin@email.com");
			page.locator("#password1").fill("admin@123");
			page.locator(".submit-btn").click();
			System.out.println("Signin Succesfull");
			
			PlaywrightAssertions.assertThat(page.locator("body")).containsText("Welcome");
			System.out.println("welcome text verified");
			
			//-----------------------------------------------Assignment 2----------------------------------------
			page.locator("//span[text()='Manage']").click();
			page.locator("//a[@class='nav-menu-item false']").first().click();
			System.out.println("Verified manage Course");
			
			page.locator("//button[text()='Add New Course ']").click();
			page.waitForTimeout(2000);
			
			page.locator("//input[@type='file']").setInputFiles(Path.of("C:\\Eclipse\\PlayWright\\PlaywrightJava\\Files\\Leo badass.jpg"));
			System.out.println("File uploaded succesfully");
			
			page.locator("//input[@name='name']").fill("Jenkeins");
			page.locator("#description").fill("Jenkeins is a tool to trigger a automation");
			page.locator("//input[@id='instructorNameId']").fill("Prasath");
			page.locator("#price").fill("10000");
			page.locator("#isPermanent").click();
			page.locator("xpath=//button[@class='menu-btn']").click();
			page.locator("//button[@class='menu-item'][2]").click();
			
			page.locator("//button[@class='action-btn']").click();
			page.waitForTimeout(2000);
			
		} 
		
		finally {
			// TODO: handle finally clause
			if(pw!=null) {pw.close();}
			if(page!=null) {page.close();}
			if(browser!=null) {browser.close();}
			
		}

	}

}
