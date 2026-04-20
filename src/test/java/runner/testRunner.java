package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

	    plugin = {
	        "pretty",
	        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	        "json:target/CucumberReports/PetStoreApiJson.json",
	        "html:target/CucumberReports/PetStoreApi.html",
	     //   "com.aventstack.chaintest.plugins.ChainTestCucumberListener:"
	    },
	    monochrome = false,
	  //tags = "@AddNewPetTest_01 or @GetPetByIdTest_01 or @PlaceOrderPetTest_01 or @GetOrderByIdTest_01",
	    features = {"src\\test\\resources\\features"},
	    glue = {"stepDefinitions","hooks"}
	)
public class testRunner extends AbstractTestNGCucumberTests {

}

