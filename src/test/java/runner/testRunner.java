package runner;

import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import testDataWrapper.TestCasesWrapper;
import utilities.JSONDataReader;
import utilities.LoggerLoad;
import utilities.configReader;

@CucumberOptions(

	    plugin = {
	        "pretty",
	        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
<<<<<<< HEAD
	        "json:target/CucumberReports/PetStoreData.json",
=======
	        "json:target/CucumberReports/PetStoreApiJson.json",
>>>>>>> 9dccecfb8fda19ebe7412b7ab29bfec4bb93e3c1
	        "html:target/CucumberReports/PetStoreApi.html",
	     //   "com.aventstack.chaintest.plugins.ChainTestCucumberListener:"
	    },
	    monochrome = false,
<<<<<<< HEAD
	  //tags = "@",
=======
	  //tags = "@AddNewPetTest_01 or @GetPetByIdTest_01 or @PlaceOrderPetTest_01 or @GetOrderByIdTest_01",
>>>>>>> 9dccecfb8fda19ebe7412b7ab29bfec4bb93e3c1
	    features = {"src\\test\\resources\\features"},
	    glue = {"stepDefinitions","hooks"}
	)
public class testRunner extends AbstractTestNGCucumberTests {
	 public static String baseUrl;
	 public static TestCasesWrapper allTestData;
	
	
	@BeforeClass
	public void globalSetup() {

	    baseUrl = configReader.getProperty("baseURL");
	    System.out.println("Base URL: " + baseUrl);

	    allTestData = JSONDataReader.readAllModules(
	        "src/test/resources/testData/jsonData.json"
	    );

	    LoggerLoad.info("Global setup completed");
	}
}

