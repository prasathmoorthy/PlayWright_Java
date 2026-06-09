package com.api.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.HttpHeader;

public class APIResponseHeaderTest {

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
public void getHeaderTest() throws IOException {
	
	APIResponse apiResponse=requestContext.get("https://gorest.co.in/public/v2/users");
	int statuscode=apiResponse.status();
	System.out.println("Status code is: "+statuscode);
	Assert.assertEquals(statuscode, 200);
	//Using map Header
	Map<String, String> mapHeaderMap=apiResponse.headers();
	
	System.out.println("--------Print API RESPONSE Headers--------");
	for(Map.Entry<String, String> entry: mapHeaderMap.entrySet()) {
		System.out.println(entry.getKey()+" : "+entry.getValue());
	}
	Assert.assertEquals(mapHeaderMap.get("connection"), "keep-alive");	
	System.out.println(mapHeaderMap.size());
	
	
	//Using ArrayList HeaderArray
System.out.println("--------Print API RESPONSE Headers using ArrayList--------");
List<HttpHeader> list= apiResponse.headersArray();

for(HttpHeader e: list) {
	System.out.println(e.name+" : "+e.value);
}
}
}
