package week3.day2.Assignment3;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	static RequestSpecification request = null;

	static Response response = null;

	static String sys_id = null;

	@BeforeMethod
	public void setup() {

		RestAssured.baseURI = "https://testleafjune2022.atlassian.net/rest/api/2/search";

		RestAssured.authentication = RestAssured.preemptive().basic("testleafjune2022@gmail.com", "WsGNjLVSPYnNbjtJ8MzN5E9C");

		request = RestAssured.given().contentType(ContentType.JSON);

	}

}
