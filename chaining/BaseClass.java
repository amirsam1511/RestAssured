package chaining;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	static RequestSpecification request = null;

	static Response response = null;

	static String issue_id = null;


	@BeforeMethod
	public void setup() {
		RestAssured.baseURI = "https://testleafjune2022.atlassian.net/rest/api/2/issue/";

		RestAssured.authentication = RestAssured.preemptive().basic("testleafjune2022@gmail.com", "4OmKJ65SLDY0QtY9sg7oF910");

		request = RestAssured.given().contentType(ContentType.JSON);

	}

}
