package week3.day2.Assignment1;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ServiceNowUpdate extends BaseClassImpl{
	@Test(dependsOnMethods = "week3.day2.Assignment1.CreateIncident.createIncident")
	public void updateIncident() {
		
		request = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
				+ "      \"short_description\": \"Put method for hamcrest\"\r\n"
				+ "}");
		
		response = request.put(sys_id);
		
		response.prettyPrint();
		
		System.out.println("Updated Sys id is " + sys_id);
		
		response.then().assertThat().statusCode(200).body("result.short_description", Matchers.equalTo("Put method for hamcrest"));
		
		
	}

}
