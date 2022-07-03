package chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateJIRARecord extends BaseClass{
	@Test
	public void createJiraRecord() {
		
		request = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"project\": {\r\n"
				+ "            \"key\": \"JUN\"\r\n"
				+ "        },\r\n"
				+ "        \"summary\": \"create issue in RA project\",\r\n"
				+ "        \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
				+ " \"issuetype\": {\r\n"
				+ "            \"id\": \"10002\"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}");
		
		response = request.post();
		
		issue_id = response.jsonPath().get("id");
		
		System.out.println("Issue Id from Create Incident is : " + issue_id);
	}

}
