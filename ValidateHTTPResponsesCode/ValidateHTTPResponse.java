package ValidateHTTPResponsesCode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import  io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ValidateHTTPResponse {
	
	@Test(enabled = false)
	
	public void GetSingleUser() {
		baseURI = "https://reqres.in/api/users/2";
		
		RequestSpecification requestspec = given();
		
		Response response = requestspec.get();
		
		// validate status code
		
		int StatusCode = response.getStatusCode();
		
		Assert.assertEquals(StatusCode,200,"Correct Staus Code Received" );
		
		//validate Status line
		
		String statusline = response.getStatusLine();
		
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK","Incorrect Statline Recieved");
		
	}
	
	@Test(enabled = false)
	
	public void GetSingleUserValidabledResponse() {
		
		baseURI = "https://reqres.in/api/users/2";
		
		RequestSpecification requestspec = given();
		
		Response response = requestspec.get();
		
		ValidatableResponse res = response.then();
		
		// Status Code
		res.statusCode(200);
		
		// Status Line
		res.statusLine("HTTP/1.1 200 OK");
	}
	
	@Test
	
	public void GetSingleUser_BDD() {
		
		 given()
		
		.when()
			.get("https://reqres.in/api/users/2")
			
		.then().statusCode(200)
				.statusLine("HTTP/1.1 200 OK");
		 	
	}


}
