package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import io.cucumber.java.en.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import hooks.Hooks;
import testDataWrapper.TestCaseData;
import pojo.GetOrderPet;
import utilities.JSONDataReader;
import utilities.LoggerLoad;

public class GetOrderPetSteps<dieticianData> {
	
	private RequestSpecification request;
	private Response response;
	TestCaseData GetOrderPetTestCase;
	GetOrderPet GetOrderInputdata;
	
	@Given("Admin creates the GET request with {string}")
	public void admin_creates_the_get_request_with_(String scenarioName) {
		  // Prepare request
        request = given()
                .baseUri(Hooks.baseUrl)
                .header("Content-Type", "application/json");
	
	    request = Hooks.request;
                       
	}
	
	@When("Admin sends a GET request with {string}")
	public void admin_sends_a_post_request_with(String scenario) {
		// load new pet test data for the given scenario
	    GetOrderPetTestCase = JSONDataReader.getTestCaseByScenario(Hooks.allTestData.getGetOrderPetTests(),
	    		scenario);
	    LoggerLoad.info("Loaded Get a order: " + GetOrderPetTestCase.getScenario());

	    // get the input data
	    GetOrderInputdata = GetOrderPetTestCase.getOrderPetInputdata();
	    LoggerLoad.info("Loaded Add New Pet Test Case: " + 
	    addNewPetInputData);

        Hooks.request = Hooks.request.body(addNewPetInputData);
        Hooks.request.log().all();
        LoggerLoad.info("Request with body prepared.");


    	String endpoint = GetOrderPetTestCase.getEndpoints();
    	 LoggerLoad.info("Endpoint: " + endpoint);
    	 response = Hooks.request.post(endpoint);

        LoggerLoad.info("Status Code: " + response.getStatusCode());
        LoggerLoad.info("Response Body: " + response.getBody().asPrettyString());

	}

	
	
	
	@Then("Admin recieves {int} ok with response body")
	public void admin_recieves_ok_with_response_body(Integer expectedStatusCode) {
	   
		assertEquals(response.getStatusCode(), expectedStatusCode.intValue(), "Status code mismatch");
	    assertTrue(response.getStatusLine().contains(expectedStatusCode.toString()));
	    assertTrue(response.getStatusLine().contains(dieticianGETAllTestCase.getExpectedStatusLineMsg()));

    }