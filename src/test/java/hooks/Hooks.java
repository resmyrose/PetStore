package hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.Before;
<<<<<<< HEAD
=======
import io.cucumber.java.BeforeAll;
>>>>>>> 9dccecfb8fda19ebe7412b7ab29bfec4bb93e3c1
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
  

<<<<<<< HEAD
    @Before()
    public void setup() {
=======
    @BeforeAll
    public static void setup() {
>>>>>>> 9dccecfb8fda19ebe7412b7ab29bfec4bb93e3c1
        // Load base URL from config
    	System.out.println("Printing Base Url" );
        baseUrl = configReader.getProperty("baseURL");
    }
        

//    @After
    public void tearDown() {
        logger.info("Cleaning up after scenario...");
        // Add cleanup steps if needed
    }
}

