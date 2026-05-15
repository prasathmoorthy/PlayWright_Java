package day3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnInputs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions()
				.setHeadless(false)
				.setChannel("msedge"));
		Page page = browser.newPage();
		page.navigate("https://letcode.in/edit");
	//	page.locator("#fullName").type("Prasath"); // write new text along with if existing text is there
		page.fill("#fullName", "Prasath");  // direct locator&fill method
		
	//	page.locator("#fullName").fill("Prasath"); //fill the text remove existing, long text data inject
	//	page.locator("#join").fill("Hello");
		
		Locator locator = page.locator("#join");
		locator.press("End"); // end is going to end of the text
		locator.type(" Boy"); //to append the function message
		locator.press("Tab"); //to press tab button
		
		
		
		String attribute= page.locator("id=getMe").getAttribute("value");
		System.out.println(attribute);                                      // get the value from ui to o/p
		
		
		page.locator("(//label[normalize-space(text())='Clear the text']/following::input)[1]").clear();
	}

}
