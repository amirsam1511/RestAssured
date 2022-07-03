package chaining;

import org.testng.annotations.Test;

public class DeleteJiraRecord extends BaseClass{
	@Test(dependsOnMethods = "chaining.UpdateJiraRecord.updateJiraRecord")
	public void deleteJiraRecord() {
		
		response = request.delete(issue_id);
		
		System.out.println("Issue Id in Deleted record is " + issue_id);

		response.then().assertThat().statusCode(204);

	}

}
