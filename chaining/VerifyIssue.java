package chaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class VerifyIssue extends BaseClass{
	@Test(dependsOnMethods = "chaining.DeleteJiraRecord.deleteJiraRecord")
	public void verifyIssue() {

		response = request.get(issue_id);

		System.out.println("Issue Id in Retrieve record is " + issue_id);

		response.prettyPrint();
		
		response.then().assertThat().statusCode(404).body("errorMessages[0]", Matchers.containsString("Issue does not exist"));
	}

}
