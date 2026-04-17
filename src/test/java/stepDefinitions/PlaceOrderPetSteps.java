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
import pojo.PlaceOrderPet;
import testDataWrapper.TestCaseData;
import utilities.JSONDataReader;
import utilities.LoggerLoad;

public class PlaceOrderPetSteps
{

	    private RequestSpecification request;
	    private Response response;
	    TestCaseData PlaceOrderPetTestCase;
	    PlaceOrderPet PlaceOrderPetInputData;
        public static String PetID;


	@Given("Admin creates the POST request with {string}")
	public void admin_creates_the_post_request_with(String string)
	{
		  // Prepare request
        request = given()
                .baseUri(Hooks.baseUrl)
                .header("Content-Type", "application/json");

        Hooks.request = request; // You should set it here so other step classes can use it
	}

	@When("Admin sends the POST request with valid data with {string}")
	public void admin_sends_the_post_request_with_valid_data_with(String scenario) 
	{
		// load place order pet test data for the given scenario
	    PlaceOrderPetTestCase = JSONDataReader.getTestCaseByScenario(Hooks.allTestData.getPlaceOrderPetTests(),
	    		scenario);
	    LoggerLoad.info("Loaded Place order Pet Test Case: " + PlaceOrderPetTestCase.getScenario());
	    System.out.println(PlaceOrderPetTestCase.getScenario());
	    // get the input data
	    PlaceOrderPetInputData = PlaceOrderPetTestCase.getPlaceOrderInputData();
	    LoggerLoad.info("Loaded Place Order Pet Test Case: " + PlaceOrderPetInputData);

        Hooks.request = Hooks.request.body(PlaceOrderPetInputData);
        Hooks.request.log().all();
        LoggerLoad.info("Request with body prepared.");


    	String endpoint = PlaceOrderPetTestCase.getEndpoints();
    	 LoggerLoad.info("Endpoint: " + endpoint);
    	 response = Hooks.request.post(endpoint);

        LoggerLoad.info("Status Code: " + response.getStatusCode());
        LoggerLoad.info("Response Body: " + response.getBody().asPrettyString());

	}

	@Then("An Order is placed to the store and admin receives response code {int}")
	public void an_order_is_placed_to_the_store_and_admin_receives_response_code(Integer expectedStatusCode)
	{
		response.prettyPrint();

        assertEquals(response.getStatusCode(), expectedStatusCode.intValue(), "Status code mismatch");

        assertTrue(response.getStatusLine().contains(expectedStatusCode.toString()));
        assertTrue(response.getStatusLine().contains(PlaceOrderPetTestCase.getExpectedStatusLineMsg()));
        if(expectedStatusCode == 201)
        {
        	
        	PetID = response.jsonPath().getString("id");
        	System.out.println("Pet_Id saved:"+ PetID);
        	LoggerLoad.info("Pet_Id saved:"+ PetID);
        	
	     }
	}
}
	
	


