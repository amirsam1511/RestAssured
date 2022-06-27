package week3.day2.Assignment1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateIncident extends BaseClassImpl{
	
	@Test
	public void createIncident() {
		
		request = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
				+ "      \"short_description\": \"Create Incident\"\r\n"
				+ "}\r\n"
				+ "");
		response = request.post();
		sys_id = response.jsonPath().get("result.sys_id");
		response.prettyPrint();
		System.out.println("Sys_id from Create Incident is : " + sys_id);

	}

}
