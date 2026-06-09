package com.api.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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

public class CreateUserWithJsonFile {

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
public void CreateUserTest() throws IOException {
	
//get Json File
	byte[] fileByte= null;
	File file=new File("./src/test/java/Data/user.json");
    fileByte=Files.readAllBytes(file.toPath());
	
	
	//Create User using POST API
	APIResponse apiPostResponse=requestContext.post("https://gorest.co.in/public/v2/users", 
				RequestOptions.create()
				.setHeader("Content-Type", "application/json")
				.setHeader("Authorization", "Bearer def967f4a149486436e711f89e0ba44233d9e27b0552050f069770fa8aa1520a")
				.setData(fileByte));
	
	
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
