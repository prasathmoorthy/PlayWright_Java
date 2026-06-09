package com.api.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;


public class GET_API {
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
public void getSpecificUser() throws IOException {
	APIResponse apiResponse=requestContext.get("https://gorest.co.in/public/v2/users",
			RequestOptions.create()
			     .setQueryParam("id", "8481828")
			);
	
	int statuscode=apiResponse.status();
	System.out.println("Status code is: "+statuscode);
	Assert.assertEquals(statuscode, 200);
	String statusText=apiResponse.statusText();
	System.out.println("Status text is: "+statusText);
	Assert.assertEquals(statusText, "OK");
	apiResponse.body();
	System.out.println("--------Print API RESPONSE TEXT--------");
	System.out.println(apiResponse.text());
	System.out.println("--------Print API RESPONSE BODY--------");

	ObjectMapper objectMapper = new ObjectMapper();
	JsonNode jsonNode=objectMapper.readTree(apiResponse.body());
	
	System.out.println(jsonNode.toPrettyString());
}



	@Test
	public void getUsersApiTest() throws IOException {
		
		APIResponse apiResponse=requestContext.get("https://gorest.co.in/public/v2/users");
		int statuscode=apiResponse.status();
		System.out.println("Status code is: "+statuscode);
		Assert.assertEquals(statuscode, 200);
		String statusText=apiResponse.statusText();
		System.out.println("Status text is: "+statusText);
		Assert.assertEquals(statusText, "OK");
		apiResponse.body();
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode=objectMapper.readTree(apiResponse.body());
		
		System.out.println(jsonNode.toPrettyString());
		
		System.out.println("--------Print API URL--------");
		System.out.println(apiResponse.url());
		assertEquals(apiResponse.url(), "https://gorest.co.in/public/v2/users");
		System.out.println("--------Print API HEADER--------");
		
		
		Map<String, String> mapHeader=apiResponse.headers();
		System.out.println(mapHeader);
		assertEquals(mapHeader.get("content-type"), "application/json; charset=utf-8");
	}
	@AfterMethod
	public void tearDown() {
		playwright.close();
		
	}

}
