package com.api.test;

import javax.swing.event.TreeWillExpandListener;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.PlaywrightException;

public class APIDisposalTest {

	Playwright playwright;
	APIRequest request;
	APIRequestContext requestContext;
	
	
@BeforeMethod	
public void setUp() {
	playwright = Playwright.create();
	request= playwright.request();
	requestContext = request.newContext();
}

@Test
public void disposeResponseTest() {
	
	//Request No 1
	APIResponse apiResponse=requestContext.get("https://gorest.co.in/public/v2/users");
	int statuscode=apiResponse.status();
	System.out.println("Status code is: "+statuscode);
	Assert.assertEquals(statuscode, 200);
	String statusText=apiResponse.statusText();
	System.out.println("Status text is: "+statusText);
	Assert.assertEquals(statusText, "OK");
	apiResponse.body();
	
	apiResponse.dispose();
//	System.out.println("-----Print api responce after Dispose-----");
//	System.out.println(apiResponse.text());
	try {
		System.out.println(apiResponse.text());
	} catch (PlaywrightException e) {
		// TODO: handle exception
		System.out.println("Api response is disposed, cannot access the text");
	}
	int statuscode2=apiResponse.status();
	System.out.println("new Status code is: "+statuscode2);
	System.out.println(apiResponse.statusText());
	System.out.println(apiResponse.url());
	

}





@AfterMethod
public void tearDown() {
	playwright.close();
	
}
	
}
