package testDataWrapper;

import pojo.AddNewPet;
import pojo.PlaceOrderPet;

public class TestCaseData {
	private String testCaseId;
	private String scenario;
	private String module;
	private String method;
	private String endpoints;
	private int expectedStatusCode;
	private String expectedStatusLineMsg;
	private String typeOfTesting;
	private String[] expectedResponseKeys;

	private AddNewPet newPetInputdata;
	private PlaceOrderPet placeOrderInputdata;
	//private GetOrderPet getOrderPetInputdata;
	
	public void getExpectedResponseKeys(String[] expectedResponseKeys) {
		this.expectedResponseKeys = expectedResponseKeys;
	}
	
	
	public void setExpectedResponseKeys(String[] expectedResponseKeys) {
		this.expectedResponseKeys = expectedResponseKeys;
	}
	public AddNewPet getNewPetInputdata() {
		return newPetInputdata;
	}
	public void setNewPetInputdata(AddNewPet newPetInputdata) {
		this.newPetInputdata = newPetInputdata;
	}
	public PlaceOrderPet getPlaceOrderInputdata() {
		return placeOrderInputdata;
	}
	public void setPlaceOrderInputdata(PlaceOrderPet placeOrderInputdata) {
		this.placeOrderInputdata = placeOrderInputdata;
	}
	public AddNewPet getNewPetInputData() {
		return newPetInputdata;
	}
	public void setNewPetInputData(AddNewPet newPetInputData) {
		this.newPetInputdata = newPetInputData;
	}
	
	public PlaceOrderPet getPlaceOrderInputData() {
		return placeOrderInputdata;
	}
	public void setPlaceOrderInputData(PlaceOrderPet placeOrderInputData) {
		this.placeOrderInputdata= placeOrderInputData;
	}
	
	public String getTestCaseId() {
		return testCaseId;
	}
	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}
	public String getScenario() {
		return scenario;
	}
	public void setScenario(String scenario) {
		this.scenario = scenario;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getEndpoints() {
		return endpoints;
	}
	public void setEndpoints(String endpoints) {
		this.endpoints = endpoints;
	}
	public int getExpectedStatusCode() {
		return expectedStatusCode;
	}
	public void setExpectedStatusCode(int expectedStatusCode) {
		this.expectedStatusCode = expectedStatusCode;
	}
	public String getExpectedStatusLineMsg() {
		return expectedStatusLineMsg;
	}
	public void setExpectedStatusLineMsg(String expectedStatusLineMsg) {
		this.expectedStatusLineMsg = expectedStatusLineMsg;
	}
	public String getTypeOfTesting() {
		return typeOfTesting;
	}
	public void setTypeOfTesting(String typeOfTesting) {
		this.typeOfTesting = typeOfTesting;
	}


}
