package chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateJiraRecord extends BaseClass{
	@Test(dependsOnMethods = "chaining.CreateJIRARecord.createJiraRecord")
	public void updateJiraRecord() {

		request = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"description\": \"Bug creation Using REST API for testing\"\r\n"
				+ "    }\r\n"
				+ "}");

		response = request.put(issue_id);

		response.prettyPrint();

		System.out.println("Issue Id in Updated record is " + issue_id);

		response.then().assertThat().statusCode(204);

	}

}
