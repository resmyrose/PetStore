package testDataWrapper;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestCasesWrapper {
	 @JsonProperty("AddNewPetTests")
	private List<TestCaseData> AddNewPetTests;

	public List<TestCaseData> getAddNewPetTests() {
		//return AddNewPetTests;
		// Petvents accidential modification and is safe for parallel execution
		return Collections.unmodifiableList(AddNewPetTests);
	}

	public void setAddNewPetTests(List<TestCaseData> AddNewPetTests) {
		// Petvents accidential modification and is safe for parallel execution.
		//The list returned by List.copyOf() makes the list unmodifiable as its a separate copy
		//Even if someone modifies the original addNewPetTests, your internal data dosen't change
		this.AddNewPetTests = List.copyOf(AddNewPetTests);
	}

}
