package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import runner.testRunner;
import testDataWrapper.TestCaseData;
import utilities.JSONDataReader;
import utilities.LoggerLoad;
import utilities.configReader;

public class GetPetSteps {
	

	 private RequestSpecification request;
	    private Response response;
	    TestCaseData getPetByIdTests;
	
	@Given("Admin creates a GET pet by id request")
	public void admin_creates_a_get_pet_by_id_request() {
//		  // Prepare request
        request = given()
                .baseUri(Hooks.baseUrl)
        		//.baseUri(configReader.getProperty("baseURL"))
                .header("Content-Type", "application/json");

        Hooks.request = request;

		getPetByIdTests = JSONDataReader.getTestCaseByScenario(Hooks.allTestData.getGetPetByIdTests(), "Get Pet Details with valid Pet Id");
	    LoggerLoad.info("Loaded Pet Test Case: " + getPetByIdTests.getScenario());

	    request = Hooks.request;
	    LoggerLoad.info("Reusing request with Bearer Token from background setup.");

	}

	@When("Admin sends a GET request with valid endpoint")
	public void admin_sends_a_get_request_with_valid_endpoint() {
		 String endpoint = getPetByIdTests.getEndpoints();
		 System.out.println("endpoint :  "+endpoint);
		 System.out.println("petId :  "+AddNewPetSteps.petId);
		    // Replace {dieticianId} with actual ID
		    String resolvedEndpoint = endpoint.replace("{petId}", AddNewPetSteps.petId);
		    System.out.println("resolvedEndpoint:  "+resolvedEndpoint);
		    LoggerLoad.info("Resolved Endpoint: " + resolvedEndpoint);

		    response = Hooks.request.get(resolvedEndpoint); // Use resolved endpoint
		    response.then().log().all();
		    
		    LoggerLoad.info("Status Code: " + response.getStatusCode());
	   
	}

	@Then("The pet details are retrieved and admin receives response code {int}")
	public void the_pet_details_are_retrieved_and_admin_receives_response_code(Integer expectedStatusCode) {
		assertEquals(response.getStatusCode(), expectedStatusCode.intValue(), "Status code mismatch");
	    assertTrue(response.getStatusLine().contains(expectedStatusCode.toString()));
	    
	}


}
