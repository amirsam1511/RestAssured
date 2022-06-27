package week3.day2.Assignment1;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClassImpl {

	static RequestSpecification request = null;

	static Response response = null;

	static String sys_id = null;

	@BeforeMethod
	public void setup() {

		RestAssured.baseURI = "https://dev106260.service-now.com/api/now/table/change_request";

		RestAssured.authentication = RestAssured.basic("admin", "U^e7ci!6SdFB");

		request = RestAssured.given().contentType(ContentType.JSON);

	}

}
