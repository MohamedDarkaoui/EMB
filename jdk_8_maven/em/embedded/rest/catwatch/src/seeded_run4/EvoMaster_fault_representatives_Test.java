import  org.junit.AfterClass;
import  org.junit.BeforeClass;
import  org.junit.Before;
import  org.junit.Test;
import static org.junit.Assert.*;
import  java.util.Map;
import  java.util.List;
import static org.evomaster.client.java.controller.api.EMTestUtils.*;
import  org.evomaster.client.java.controller.SutHandler;
import  io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import  io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;
import  io.restassured.config.JsonConfig;
import  io.restassured.path.json.config.JsonPathConfig;
import static io.restassured.config.RedirectConfig.redirectConfig;
import static org.evomaster.client.java.controller.contentMatchers.NumberMatcher.*;
import static org.evomaster.client.java.controller.contentMatchers.StringMatcher.*;
import static org.evomaster.client.java.controller.contentMatchers.SubStringMatcher.*;
import static org.evomaster.client.java.controller.expect.ExpectationHandler.expectationHandler;
import  org.evomaster.client.java.controller.expect.ExpectationHandler;
import  io.restassured.path.json.JsonPath;
import  java.util.Arrays;




/**
 * This file was automatically generated by EvoMaster on 2024-06-02T21:56:35.949+02:00[Europe/Paris]
 * <br>
 * The generated test suite contains 6 tests
 * <br>
 * Covered targets: 981
 * <br>
 * Used time: 1h 3m 38s
 * <br>
 * Needed budget for current results: 98%
 * <br>
 * This file contains one example of each category of fault. The test cases in this file are a subset of the set of test cases likely to indicate faults.
 */
public class EvoMaster_fault_representatives_Test {

    
    private static final SutHandler controller = new em.embedded.org.zalando.EmbeddedEvoMasterController();
    private static String baseUrlOfSut;
    /** [ems] - expectations master switch - is the variable that activates/deactivates expectations individual test cases
    * by default, expectations are turned off. The variable needs to be set to [true] to enable expectations
    */
    private static boolean ems = false;
    /**
    * sco - supported code oracle - checking that the response status code is among those supported according to the schema
    */
    private static boolean sco = false;
    
    
    @BeforeClass
    public static void initClass() {
        controller.setupForGeneratedTest();
        baseUrlOfSut = controller.startSut();
        controller.registerOrExecuteInitSqlCommandsIfNeeded();
        assertNotNull(baseUrlOfSut);
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.urlEncodingEnabled = false;
        RestAssured.config = RestAssured.config()
            .jsonConfig(JsonConfig.jsonConfig().numberReturnType(JsonPathConfig.NumberReturnType.DOUBLE))
            .redirect(redirectConfig().followRedirects(false));
    }
    
    
    @AfterClass
    public static void tearDown() {
        controller.stopSut();
    }
    
    
    @Before
    public void initTest() {
        controller.resetDatabase(Arrays.asList());
        controller.resetStateOfSUT();
    }
    
    
    
    
    /**
    * [test_0_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_0_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/projects?" + 
                    "organizations=zalando&" + 
                    "EMextraParam123=42")
                .then()
                .statusCode(500) // org/zalando/catwatch/backend/service/ProjectServiceImpl_62_findProjects
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'exception'", containsString("java.lang.NullPointerException"))
                .body("'message'", containsString("No message available"))
                .body("'path'", containsString("/projects"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_1_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_3
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_1_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_225_XYZ_")
                .get(baseUrlOfSut + "/statistics/contributors?organizations=")
                .then()
                .statusCode(500) // org/zalando/catwatch/backend/web/StatisticsApi_165_statisticsContributorGet
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'exception'", containsString("java.lang.IndexOutOfBoundsException"))
                .body("'message'", containsString("toIndex = 10"))
                .body("'path'", containsString("/statistics/contributors"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_2_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_2
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_2_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_19_XYZ_")
                .get(baseUrlOfSut + "/contributors?" + 
                    "organizations=l2A&" + 
                    "limit=957&" + 
                    "offset=386&" + 
                    "end_date=_EM_16_XYZ_&" + 
                    "sortBy=kGKY9DOr&" + 
                    "q=_EM_17_XYZ_")
                .then()
                .statusCode(500) // org/zalando/catwatch/backend/web/ContributorsApi_221_validate
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'exception'", containsString("java.lang.IllegalArgumentException"))
                .body("'message'", containsString("sortBy must be empty or have a valid value but was kGKY9DOr. Valid values are organizationalCommitsCount,organizationalProjectsCount,personalCommitsCount,personalProjectsCount,organizationName,name"))
                .body("'path'", containsString("/contributors"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_3_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_1
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_3_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/contributors?" + 
                    "organizations=IBM%2CSun&" + 
                    "sortBy=-organizationalCommitsCount&" + 
                    "EMextraParam123=42")
                .then()
                .statusCode(500) // org/zalando/catwatch/backend/web/ContributorsApi_128_contributorsGet
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'exception'", containsString("java.lang.UnsupportedOperationException"))
                .body("'message'", containsString("this parameter configuration is not implemented yet .. start date, end date required atm"))
                .body("'path'", containsString("/contributors"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_4_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_4_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/projects?" + 
                    "limit=381&" + 
                    "offset=450&" + 
                    "start_date=1939-06-28T00%3A54%3A15&" + 
                    "EMextraParam123=_EM_33_XYZ_")
                .then()
                .statusCode(500) // org/zalando/catwatch/backend/github/RepositoryWrapper_124_listTags
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'exception'", containsString("java.lang.NullPointerException"))
                .body("'message'", containsString("No message available"))
                .body("'path'", containsString("/projects"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_5() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        try{
            given().accept("*/*")
                    .header("x-EMextraHeader123", "")
                    .get(baseUrlOfSut + "/fetch");
        } catch(Exception e){
        }
    }


}