package testDataWrapper;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestCasesWrapper {
	
   @JsonProperty("AddNewPetTests")
   private List<TestCaseData> AddNewPetTests;
   @JsonProperty("PlaceOrderPetTests")
	private List<TestCaseData> PlaceOrderPetTests;
   @JsonProperty("PlaceOrderPetTests")
	private List<TestCaseData> GetOrderPetTests;
	

	public List<TestCaseData> getAddNewPetTests() {
		return AddNewPetTests;
	}

	public void setAddNewPetTests(List<TestCaseData> AddNewPetTests) {
		this.AddNewPetTests = AddNewPetTests;
	}
	public List<TestCaseData> getPlaceOrderPetTests() {
		return PlaceOrderPetTests;
	}

	public void setPlaceOrderPetTests(List<TestCaseData> placeOrderPetTests) {
		this.PlaceOrderPetTests = placeOrderPetTests;
	}

	public List<TestCaseData> getGetOrderPetTests() {
		return GetOrderPetTests;
	}

	public void setGetOrderPetTests(List<TestCaseData> getOrderPetTests) {
		GetOrderPetTests = getOrderPetTests;
	}
	
	
}
