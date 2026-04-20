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
import testDataWrapper.TestCaseData;
import utilities.JSONDataReader;
import utilities.LoggerLoad;

public class DeletePetSteps {
	private RequestSpecification request;
    private Response response;
    TestCaseData deletePetByIdTests;

	@Given("Admin creates a DELETE pet by id request")
	public void admin_creates_a_delete_pet_by_id_request() {
		  // Prepare request
        request = given()
                .baseUri(Hooks.baseUrl)
                .header("Content-Type", "application/json");

        Hooks.request = request;

		deletePetByIdTests = JSONDataReader.getTestCaseByScenario(Hooks.allTestData.getDeletePetByIdTests(), "Delete Pet Details with valid Pet Id");
	    LoggerLoad.info("Loaded Pet Test Case: " + deletePetByIdTests.getScenario());

	    request = Hooks.request;
	    LoggerLoad.info("Reusing request with Bearer Token from background setup.");
	}

	@When("Admin sends a DELETE request with valid endpoint")
	public void admin_sends_a_delete_request_with_valid_endpoint() {
		String endpoint = deletePetByIdTests.getEndpoints();
		 System.out.println("endpoint :  "+endpoint);
		 
		    // Replace {dieticianId} with actual ID
		    String resolvedEndpoint = endpoint.replace("{petId}", AddNewPetSteps.petId);
		    System.out.println("resolvedEndpoint:  "+resolvedEndpoint);
		    LoggerLoad.info("Resolved Endpoint: " + resolvedEndpoint);

		    response = Hooks.request.get(resolvedEndpoint); // Use resolved endpoint
		    response.then().log().all();
		    
		    LoggerLoad.info("Status Code: " + response.getStatusCode());
	}

	@Then("The pet details are Deleted and admin receives response code {int}")
	public void the_pet_details_are_deleted_and_admin_receives_response_code(Integer expectedStatusCode) {
		assertEquals(response.getStatusCode(), expectedStatusCode.intValue(), "Status code mismatch");
	    assertTrue(response.getStatusLine().contains(expectedStatusCode.toString()));
	}

}
