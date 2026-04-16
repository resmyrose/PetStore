package hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.BeforeAll;
import io.restassured.specification.RequestSpecification;
import testDataWrapper.TestCasesWrapper;
import utilities.JSONDataReader;
import utilities.LoggerLoad;
import utilities.configReader;

public class Hooks {

    private static final Logger logger = LogManager.getLogger(Hooks.class);

    public static String baseUrl;
    public static TestCasesWrapper allTestData;
    public static RequestSpecification request;
  

    @BeforeAll()
    public static void setup() {
        // Load base URL from config
        baseUrl = configReader.getProperty("baseURL");
        LoggerLoad.info("Base URL loaded: " + baseUrl);

       // System.out.println("In Hooks class.........");

        // Load all test data from JSON
        allTestData = JSONDataReader.readAllModules("src/test/resources/testData/jsonData.json");

        LoggerLoad.info("All test data loaded");
    }

//    @After
    public void tearDown() {
        logger.info("Cleaning up after scenario...");
        // Add cleanup steps if needed
    }
}

