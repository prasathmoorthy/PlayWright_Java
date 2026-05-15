package day4;

//REMOVE or COMMENT OUT this line
//import java.awt.List;
import java.util.List;
import java.util.*; // <-- keep this if you use other util classes (optional)

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class LearnDropdowns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwrite=Playwright.create();
		LaunchOptions headless=new BrowserType.LaunchOptions().setHeadless(false);
		Page page=playwrite.chromium().launch(headless).newPage();
		page.navigate("https://letcode.in/dropdowns");
	//	page.selectOption("#fruits","4");
		
		Locator fruitDD=page.locator("#fruits");
		fruitDD.selectOption(new SelectOption().setLabel("Banana"));
		String notify= page.locator("//div[@class='notification is-success']//p[1]").textContent();
		System.out.println(notify);
		
		Locator hero=page.locator("#superheros");
		hero.selectOption(new String[] {"ta","ca", "im"});
		
		Locator langDD=page.locator("#lang");
		Locator optionDD=langDD.locator("option");
		List<String> ss = optionDD.allInnerTexts();
		for (String string : ss) {
			System.out.println(string);
		}
		
		
		int c= optionDD.count();
		System.out.println("Length :"+(c));
		langDD.selectOption(new SelectOption().setIndex(c-1));
		
		
	}

}
