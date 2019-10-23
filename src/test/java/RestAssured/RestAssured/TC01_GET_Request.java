package RestAssured.RestAssured;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_GET_Request {

	@Test
	void getWeatherDetails() {
		// Specify the URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Response Object
	
		Response response=httpRequest.request(io.restassured.http.Method.GET, "/Nagpur");
		//	Response response = httpRequest.request(Method.GET, "/Hyderabad");

		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		//status Code
		int code=response.getStatusCode();
		System.out.println("Status Code-------->"+code);
		if(code==200) {
			System.out.println("Sucessfull excecution of test cases");
		}
		else {
			System.out.println("Failed");
		}
		
		Assert.assertEquals(code, 200);
		String statusLine=response.getStatusLine();
		System.out.println("Status Line is-->"+statusLine);

		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
}
