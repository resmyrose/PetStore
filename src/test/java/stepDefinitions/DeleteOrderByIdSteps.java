package stepDefinitions;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import hooks.Hooks;
import testDataWrapper.TestCaseData;

import utilities.JSONDataReader;
import utilities.LoggerLoad;

public class DeleteOrderByIdSteps {
	
	private RequestSpecification request;
	private Response response;
	TestCaseData DeleteOrderByIdTestCase;
	
	
	@Given("Admin creates DELETE request for Order by ID")
	public void admin_creates_delete_request_for_order_by_id() {
		// Prepare request
				Hooks.request = given()
			            .baseUri(Hooks.baseUrl)
			            .header("Content-Type", "application/json");
				 
	}

	@When("Admin sends DELETE request with {string}")
	public void admin_sends_delete_request_with_(String scenario) {
		 DeleteOrderByIdTestCase = JSONDataReader.getTestCaseByScenario(Hooks.allTestData.getDeleteOrderByIdPetTests(),
	    		scenario); 
		 LoggerLoad.info("Delete Order by Id Test Case: " + DeleteOrderByIdTestCase.getScenario());
		 
		 String endpoint = DeleteOrderByIdTestCase.getEndpoints();
    	 LoggerLoad.info("Endpoint: " + endpoint);
    	 System.out.println("Endpoint"      +endpoint);
    	 
    	 //replace {petId} with actual ID
    	 String resolvedEndpoint = endpoint.replace("{orderId}", "3"); 
    	 //PlaceOrderPetSteps.PetID)
		    LoggerLoad.info("Resolved Endpoint: " + resolvedEndpoint);

		    response = Hooks.request.get(resolvedEndpoint); // Use resolved endpoint
		    response.then().log().all();
    	
    
	}

	@Then("Admin receives {int} ok with order id details")
	public void admin_receives_ok_with_order_id_details(Integer expectedStatuscode) {
		assertEquals(response.getStatusCode(), expectedStatuscode.intValue(), "Status code mismatch");
	    assertTrue(response.getStatusLine().contains(expectedStatuscode.toString()));
	    assertTrue(response.getStatusLine().contains(DeleteOrderByIdTestCase.getExpectedStatusLineMsg()));
    } 
}

