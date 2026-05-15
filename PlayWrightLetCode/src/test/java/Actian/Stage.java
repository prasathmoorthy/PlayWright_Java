package Actian;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Stage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions()
				.setHeadless(false)
				.setChannel("msedge"));
		Page page = browser.newPage();
		page.navigate("https://console.stage.actiandataplatform.com/");
		//username
		page.locator("#username").type("prasath.t@actian.com.idp");
		page.locator("//button[contains(@class,'btn btn-primary')]").click();
		
		//weight for the page
		page.locator("//input[contains(@class,'input sfdc_passwordinput')]").waitFor();
		//password
		page.locator("//input[contains(@class,'input sfdc_passwordinput')]").type("Tommy@Naayae28");
		page.locator("//button[contains(@class,'slds-button slds-button_neutral')]//span[1]").click();
		// w8 for the page
		
		page.waitForLoadState();
		
		// Wait until the link is visible and click it
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Warehouses"))
		    .waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Warehouses")).click();

		// Then wait for navigation can be done this way
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		page.waitForLoadState(LoadState.NETWORKIDLE);
		Locator button = page.locator("(//div[@class='btn-group dropdown']//button)[3]");
		button.waitFor();  // wait until visible/enabled (optional)
		button.click();
		
		page.locator("//a[contains(text(),'Start Warehouse')]").waitFor(); // Wait for the option
		page.locator("//a[contains(text(),'Start Warehouse')]").click();


	}

}




