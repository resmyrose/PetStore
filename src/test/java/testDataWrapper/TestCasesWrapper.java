package testDataWrapper;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestCasesWrapper {
	

   @JsonProperty("AddNewPetTests")
	private List<TestCaseData> AddNewPetTests;
	 @JsonProperty("PlaceOrderPetTests")
	private List<TestCaseData> PlaceOrderPetTests;
	 @JsonProperty("GetPetByIdTests")
	 private List<TestCaseData> GetPetByIdTests;
	 @JsonProperty("DeletePetByIdTests")
	 private List<TestCaseData>DeletePetByIdTests;
     @JsonProperty("GetOrderPetTests")
	 private List<TestCaseData> GetOrderPetTests;

	

	public List<TestCaseData> getDeletePetByIdTests() {
		return DeletePetByIdTests;
	}

	public void setDeletePetByIdTests(List<TestCaseData> deletePetByIdTests) {
		DeletePetByIdTests = deletePetByIdTests;
	}

	public List<TestCaseData> getGetPetByIdTests() {
		return GetPetByIdTests;
	}

	public void setGetPetByIdTests(List<TestCaseData> getPetByIdTests) {
		GetPetByIdTests = getPetByIdTests;
	}

	public List<TestCaseData> getAddNewPetTests() {
		//return AddNewPetTests;
		// Prevents accidental modification and is safe for parallel execution
		return Collections.unmodifiableList(AddNewPetTests);
	}

	public void setAddNewPetTests(List<TestCaseData> AddNewPetTests) {
		// Prevents accidental modification and is safe for parallel execution.
		//The list returned by List.copyOf() makes the list unmodifiable as its a separate copy
		//Even if someone modifies the original addNewPetTests, your internal data dosen't change
		this.AddNewPetTests = List.copyOf(AddNewPetTests);
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
