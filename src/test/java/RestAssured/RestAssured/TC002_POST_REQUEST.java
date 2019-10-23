package RestAssured.RestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_REQUEST {
	@Test
	void register_successful() {
		// Specify the URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		// request Object
		RequestSpecification httpRequest = RestAssured.given();
		// request payload sending along with post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Laxman");
		requestParams.put("LastName", "Bhosale");
		requestParams.put("UserName", "Lucky");
		requestParams.put("Password", "Laxman007@2011");
		requestParams.put("Email", "laxmanbhosale007@gmail.com");

		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(requestParams.toJSONString());//attach data to the request
		// Response Object

		Response response = httpRequest.request(io.restassured.http.Method.POST, "/register");
		// Response response = httpRequest.request(Method.GET, "/Hyderabad");

		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		// status Code
		int code = response.getStatusCode();
		System.out.println("Status Code-------->" + code);

		// success code validation
		String successCode = response.jsonPath().get("SuccessCode");

		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	}
}
