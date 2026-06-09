package com.api.test;

import static org.testng.Assert.assertEquals;

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

public class CreateUserPostTest {

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

public static String getRandomEmail() {
	String email="test"+System.currentTimeMillis()+"@gmail.com";
	return email;
}

@Test
public void CreateUserTest() throws IOException {
	
	Map<String, Object> map=new HashMap<String, Object>();
	map.put("name", "Prasath");
	map.put("email", getRandomEmail());
	map.put("gender", "Male");
	map.put("status", "Active");
	
	//Create User using POST API
	APIResponse apiPostResponse=requestContext.post("https://gorest.co.in/public/v2/users", 
				RequestOptions.create()
				.setHeader("Content-Type", "application/json")
				.setHeader("Authorization", "Bearer def967f4a149486436e711f89e0ba44233d9e27b0552050f069770fa8aa1520a")
				.setData(map));
	
	
	int statuscode=apiPostResponse.status();
	System.out.println("Status code is: "+statuscode);
	Assert.assertEquals(statuscode, 201);
	System.out.println("--------Print API RESPONSE TEXT--------");
	
	ObjectMapper objectMapper = new ObjectMapper();
	JsonNode jsonNode=objectMapper.readTree(apiPostResponse.body());
	System.out.println(jsonNode.toPrettyString());
	
	
	//Capture ID
	String userID=jsonNode.get("id").asText();
	System.out.println("Created User ID is: "+userID);
	
	APIResponse  apiGetResponse=requestContext.get("https://gorest.co.in/public/v2/users/"+userID,
			RequestOptions.create()
		     .setHeader("Authorization", "Bearer def967f4a149486436e711f89e0ba44233d9e27b0552050f069770fa8aa1520a"));
	Assert.assertEquals(apiGetResponse.status(), 200);
	Assert.assertEquals(apiGetResponse.statusText(), "OK");
	System.out.println("--------Print API RESPONSE TEXT--------");
	System.out.println(apiGetResponse.text());
	Assert.assertTrue(apiGetResponse.text().contains(userID));
}

}
