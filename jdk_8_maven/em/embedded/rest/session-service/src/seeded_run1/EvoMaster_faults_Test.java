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
 * This file was automatically generated by EvoMaster on 2024-06-02T04:59:51.447+02:00[Europe/Paris]
 * <br>
 * The generated test suite contains 6 tests
 * <br>
 * Covered targets: 42
 * <br>
 * Used time: 0h 10m 1s
 * <br>
 * Needed budget for current results: 64%
 * <br>
 * This file contains test cases that are likely to indicate faults.
 */
public class EvoMaster_faults_Test {

    
    private static final SutHandler controller = new em.embedded.org.cbioportal.session_service.EmbeddedEvoMasterController();
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
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/sessions/_;d/settings")
                .then()
                .statusCode(500) // framework_code
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'path'", containsString("/api/sessions/_;d/settings"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_1_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_1_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "mCDaPqIRw")
                .get(baseUrlOfSut + "/api/sessions/GIMgbHxspyXH/comparison_session/6lWwlIu%25iVF_4?" + 
                    "EMextraParam123=_EM_980_XYZ_&" + 
                    "field=&" + 
                    "value=_EM_981_XYZ_")
                .then()
                .statusCode(500) // framework_code
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'path'", containsString("/api/sessions/GIMgbHxspyXH/comparison_session/6lWwlIu%25iVF_4"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_2_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_2_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .delete(baseUrlOfSut + "/api/sessions/_EM_1583_XYZ_/group/k4no;O6?EMextraParam123=_EM_1585_XYZ_")
                .then()
                .statusCode(500) // framework_code
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'path'", containsString("/api/sessions/_EM_1583_XYZ_/group/k4no;O6"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 204, 401, 403).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_3_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_3_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" \"_EM_5474_XYZ_\" ")
                .put(baseUrlOfSut + "/api/sessions/QoIGIk7nnsZ;nC/comparison_session/_EM_5473_XYZ_")
                .then()
                .statusCode(500) // framework_code
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'path'", containsString("/api/sessions/QoIGIk7nnsZ;nC/comparison_session/_EM_5473_XYZ_"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_4_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_4_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" \"group\" ")
                .post(baseUrlOfSut + "/api/sessions/c%5Bh4a;bHSX/main_session")
                .then()
                .statusCode(500) // framework_code
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'path'", containsString("/api/sessions/c%5Bh4a;bHSX/main_session"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_5_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    */
    @Test(timeout = 60000)
    public void test_5_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" \"main_session\" ")
                .post(baseUrlOfSut + "/api/sessions/msk_portal/main_session?EMextraParam123=42")
                .then()
                .statusCode(500) // org/cbioportal/session_service/domain/Session_74_setData
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'path'", containsString("/api/sessions/msk_portal/main_session"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }


}
