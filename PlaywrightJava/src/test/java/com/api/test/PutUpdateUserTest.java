package com.api.test;

import java.io.IOException;
import java.util.HashMap;
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

public class PutUpdateUserTest {
	
	Playwright playwright;
	APIRequest request;
	APIRequestContext requestContext;
	
	
@BeforeMethod	
public void setUp() {
	playwright = Playwright.create();
	request= playwright.request();
	requestContext = request.newContext();
}
@AfterMethod
public void tearDown() {
	playwright.close();
}


@Test
public void PutUpdateUserTest() throws IOException {
	
	Map<String, Object> map=new HashMap<String, Object>();
//	map.put("name", "Prasath Thirumoorthy");
//	map.put("email", getRandomEmail());
//	map.put("gender", "Male");
	map.put("status", "inActive");
	
	//Create User using PUT API
	APIResponse apiPutResponse=requestContext.put("https://gorest.co.in/public/v2/users/8487744", 
				RequestOptions.create()
				.setHeader("Content-Type", "application/json")
				.setHeader("Authorization", "Bearer def967f4a149486436e711f89e0ba44233d9e27b0552050f069770fa8aa1520a")
				.setData(map));
	
	ObjectMapper objectMapper = new ObjectMapper();
	JsonNode jsonNode=objectMapper.readTree(apiPutResponse.body());
	System.out.println(jsonNode.toPrettyString());
	Assert.assertEquals(apiPutResponse.status(), "200");
	//Assert.assertEquals(api, null)
}

}
