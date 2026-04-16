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
import pojo.AddNewPet;
import testDataWrapper.TestCaseData;
import utilities.JSONDataReader;
import utilities.LoggerLoad;

public class AddNewPetSteps {

	 private RequestSpecification request;
	    private Response response;
	    TestCaseData addNewPetTestCase;
	    AddNewPet addNewPetInputData;
	    public static String petId = "338"; // to save the petId



	@Given("Admin creates a POST request with {string}")
	public void admin_creates_a_post_request_with(String string) {
		  // Prepare request
        request = given()
                .baseUri(Hooks.baseUrl)
                .header("Content-Type", "application/json");

        Hooks.request = request; // You should set it here so other step classes can use it
	}

	@When("Admin sends a POST request with valid data with {string}")
	public void admin_sends_a_post_request_with_valid_data_with(String scenario) {
		// load new pet test data for the given scenario
	    addNewPetTestCase = JSONDataReader.getTestCaseByScenario(Hooks.allTestData.getAddNewPetTests(),
	    		scenario);
	    LoggerLoad.info("Loaded Add a Pet Test Case: " + addNewPetTestCase.getScenario());

	    // get the input data
	    addNewPetInputData = addNewPetTestCase.getNewPetInputData();
	    LoggerLoad.info("Loaded Add New Pet Test Case: " + addNewPetInputData);

        Hooks.request = Hooks.request.body(addNewPetInputData);
        Hooks.request.log().all();
        LoggerLoad.info("Request with body prepared.");


    	String endpoint = addNewPetTestCase.getEndpoints();
    	 LoggerLoad.info("Endpoint: " + endpoint);
    	 response = Hooks.request.post(endpoint);

        LoggerLoad.info("Status Code: " + response.getStatusCode());
        LoggerLoad.info("Response Body: " + response.getBody().asPrettyString());

	}

	@Then("A new pet is added to the store and admin receives response code {int}")
	public void a_new_pet_is_added_to_the_store_and_admin_receives_response_code(Integer expectedStatusCode) {
		response.prettyPrint();
		// save the pet id if the pet if added successfully
		if(response.getStatusCode() == 200) {
			petId = response.jsonPath().getString("id");
			System.out.println("Pet Id for the new pet is:"+ petId);
		}

        assertEquals(response.getStatusCode(), expectedStatusCode.intValue(), "Status code mismatch");

        assertTrue(response.getStatusLine().contains(expectedStatusCode.toString()));
        assertTrue(response.getStatusLine().contains(addNewPetTestCase.getExpectedStatusLineMsg()));
	}

}
