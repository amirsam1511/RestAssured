package week3.day2.Assignment3;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class GetAllIssues extends BaseClass{
	@Test
	public void getAllIssues() {
		
		request = RestAssured.given().contentType(ContentType.JSON).queryParam("jql", "project=JUN AND created>=-5h");
		
		response = request.get();
		
		Integer total = response.jsonPath().get("total");
		
		System.out.println("No of issues present in JIRA " + total);
		
		response.prettyPrint();
		
		ValidatableResponse resp = response.then().assertThat().statusCode(200);
		
		resp.time(Matchers.lessThan(3000L));
		
		response.then().assertThat().body("issues[1].key", Matchers.containsString("JUN"));
		
		response.then().assertThat().body("issues[1].key", Matchers.hasLength(7));

	}

}
