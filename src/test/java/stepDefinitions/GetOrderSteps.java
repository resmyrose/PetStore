package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import io.cucumber.java.en.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import hooks.Hooks;
import testDataWrapper.TestCaseData;

import utilities.JSONDataReader;
import utilities.LoggerLoad;

public class GetOrderSteps
{
	
	private RequestSpecification request;
	private Response response;
	TestCaseData GetOrderTestCase;
	 
	
   
	@Given("Admin creates the GET request with {string}")
	public void admin_creates_the_get_request_with_(String scenarioName) {
		  // Prepare request
		Hooks.request = given()
	            .baseUri(Hooks.baseUrl)
	            .header("Content-Type", "application/json");
		
		               
	}
	
	@When("Admin sends the GET request for Inventory with {string}")
	public void admin_sends_the_get_request_for_inventory_with(String scenario) {
		// get order pet test data for the given scenario
	   // GetOrderTestCase = JSONDataReader.getTestCaseByScenario(Hooks.allTestData.getGetOrderPetTests(),
	    //		scenario);
	    GetOrderTestCase = JSONDataReader.getTestCaseByScenario(Hooks.allTestData.getGetOrderPetTests(), "Returns Pet Inventories by Status");
	    LoggerLoad.info("Pet Test Case: " + GetOrderTestCase.getScenario());
	    

	   

    	String endpoint = GetOrderTestCase.getEndpoints();
    	 LoggerLoad.info("Endpoint: " + endpoint);
    	 System.out.println("Endpoint"      +endpoint);
    	 response = Hooks.request.get(endpoint);
        
        LoggerLoad.info("Status Code: " + response.getStatusCode());
        LoggerLoad.info("Response Body: " + response.getBody().asPrettyString());

	}
	
	@Then("Admin receives response code {int}")
	public void admin_receives_response_code(Integer expectedStatusCode)
	{
		 for (String key : GetOrderTestCase.getExpectedResponseKeys())
		    {
		        assertTrue(response.getBody().asString().contains(key));
		    }
		assertEquals(response.getStatusCode(), expectedStatusCode.intValue(), "Status code mismatch");
	    assertTrue(response.getStatusLine().contains(expectedStatusCode.toString()));
	    assertTrue(response.getStatusLine().contains(GetOrderTestCase.getExpectedStatusLineMsg()));
    }
}
