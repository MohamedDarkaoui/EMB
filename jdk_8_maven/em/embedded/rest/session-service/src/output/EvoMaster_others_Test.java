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
 * This file was automatically generated by EvoMaster on 2024-05-05T04:40:23.416+02:00[Europe/Paris]
 * <br>
 * The generated test suite contains 11 tests
 * <br>
 * Covered targets: 135
 * <br>
 * Used time: 0h 3m 21s
 * <br>
 * Needed budget for current results: 52%
 * <br>
 * This file contains test cases that represent failed calls, but not indicative of faults.
 */
public class EvoMaster_others_Test {

    
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
    
    
    
    
    @Test(timeout = 60000)
    public void test_0() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_193_XYZ_")
                .get(baseUrlOfSut + "/api/sessions/_EM_358_XYZ_/custom_data/query?EMextraParam123=42")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(400.0))
                .body("'error'", containsString("Bad Request"))
                .body("'path'", containsString("/api/sessions/_EM_358_XYZ_/custom_data/query"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_1() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" \"main_session\" ")
                .post(baseUrlOfSut + "/api/sessions/msk_portal/main_session/query/fetch?EMextraParam123=42")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(400.0))
                .body("'error'", containsString("Bad Request"))
                .body("'path'", containsString("/api/sessions/msk_portal/main_session/query/fetch"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_2() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/sessions/_EM_314_XYZ_/EVOMASTER?EMextraParam123=_EM_315_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(400.0))
                .body("'error'", containsString("Bad Request"))
                .body("'path'", containsString("/api/sessions/_EM_314_XYZ_/EVOMASTER"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_3() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" \"EVOMASTER\" ")
                .post(baseUrlOfSut + "/api/sessions/msk_portal/EVOMASTER?EMextraParam123=42")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(400.0))
                .body("'error'", containsString("Bad Request"))
                .body("'path'", containsString("/api/sessions/msk_portal/EVOMASTER"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_4() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_74_XYZ_")
                .contentType("application/json")
                .body(" \"jfO50TNCI0OsuK5\" ")
                .put(baseUrlOfSut + "/api/sessions/_EM_70_XYZ_/EVOMASTER/m?EMextraParam123=_EM_73_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(400.0))
                .body("'error'", containsString("Bad Request"))
                .body("'path'", containsString("/api/sessions/_EM_70_XYZ_/EVOMASTER/m"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_5() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_39_XYZ_")
                .delete(baseUrlOfSut + "/api/sessions/_EM_37_XYZ_/EVOMASTER/_EM_38_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(400.0))
                .body("'error'", containsString("Bad Request"))
                .body("'path'", containsString("/api/sessions/_EM_37_XYZ_/EVOMASTER/_EM_38_XYZ_"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 204, 401, 403).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_6() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/sessions/msk_portal/main_session/query?" + 
                    "field=%24data.portal-session.title&" + 
                    "value=my+portal+session&" + 
                    "EMextraParam123=42")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(400.0))
                .body("'error'", containsString("Bad Request"))
                .body("'path'", containsString("/api/sessions/msk_portal/main_session/query"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_7() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/sessions/msk_portal/main_session/query?" + 
                    "field=data.p%00ortal-session.title&" + 
                    "value=my+portal+session&" + 
                    "EMextraParam123=42")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(400.0))
                .body("'error'", containsString("Bad Request"))
                .body("'path'", containsString("/api/sessions/msk_portal/main_session/query"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_8() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/sessions/msk_portal/main_session/66368e046f17eb581e883cb5?EMextraParam123=42")
                .then()
                .statusCode(404)
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(404.0))
                .body("'error'", containsString("Not Found"))
                .body("'path'", containsString("/api/sessions/msk_portal/main_session/66368e046f17eb581e883cb5"));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_9() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" \"id\" ")
                .put(baseUrlOfSut + "/api/sessions/msk_portal/main_session/id?EMextraParam123=42")
                .then()
                .statusCode(404)
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(404.0))
                .body("'error'", containsString("Not Found"))
                .body("'path'", containsString("/api/sessions/msk_portal/main_session/id"));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_10() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .delete(baseUrlOfSut + "/api/sessions/msk_portal/main_session/66368e046f17eb581e883cb5?EMextraParam123=42")
                .then()
                .statusCode(404)
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(404.0))
                .body("'error'", containsString("Not Found"))
                .body("'path'", containsString("/api/sessions/msk_portal/main_session/66368e046f17eb581e883cb5"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 204, 401, 403).contains(res_0.extract().statusCode()));
    }


}
