package testDataWrapper;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestCasesWrapper {
	 @JsonProperty("AddNewPetTests")
	private List<TestCaseData> AddNewPetTests;

	public List<TestCaseData> getAddNewPetTests() {
		return AddNewPetTests;
	}

	public void setAddNewPetTests(List<TestCaseData> AddNewPetTests) {
		this.AddNewPetTests = AddNewPetTests;
	}

}
