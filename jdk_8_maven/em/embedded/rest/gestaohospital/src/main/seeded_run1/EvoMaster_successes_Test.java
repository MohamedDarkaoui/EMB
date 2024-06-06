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
 * This file was automatically generated by EvoMaster on 2024-05-31T22:28:16.227+02:00[Europe/Paris]
 * <br>
 * The generated test suite contains 4 tests
 * <br>
 * Covered targets: 339
 * <br>
 * Used time: 0h 10m 10s
 * <br>
 * Needed budget for current results: 70%
 * <br>
 * This file contains test cases that represent successful calls.
 */
public class EvoMaster_successes_Test {

    
    private static final SutHandler controller = new em.embedded.br.com.codenation.hospital.EmbeddedEvoMasterController();
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
                .get(baseUrlOfSut + "/v2/api-docs")
                .then()
                .statusCode(200);
        
        expectationHandler.expect(ems)
            /*
             Note: No supported codes appear to be defined. https://swagger.io/docs/specification/describing-responses/.
             This is somewhat unexpected, so the code below is likely to lead to a failed expectation
            */
            .that(sco, Arrays.asList().contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_1() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/v1/hospitais/?EMextraParam123=_EM_33_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_2() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"address\": \"y\", " + 
                    " \"beds\": 547, " + 
                    " \"latitude\": \"0DVmol7\", " + 
                    " \"longitude\": \"\", " + 
                    " \"name\": \"o0zygiwKkA_0kNe\" " + 
                    " } ")
                .post(baseUrlOfSut + "/v1/hospitais/")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'name'", containsString("o0zygiwKkA_0kNe"))
                .body("'address'", containsString("y"))
                .body("'beds'", numberMatches(547.0))
                .body("'availableBeds'", numberMatches(0.0))
                .body("'longitude'", containsString("12.674297"))
                .body("'latitude'", containsString("42.6384261"));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_3() throws Exception {
        
        String location_hospitais = "";
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"address\": \"y\", " + 
                    " \"beds\": 547, " + 
                    " \"latitude\": \"0DVmol7\", " + 
                    " \"longitude\": \"\", " + 
                    " \"name\": \"o0zygiwKkA_0kNe\" " + 
                    " } ")
                .post(baseUrlOfSut + "/v1/hospitais/")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'name'", containsString("o0zygiwKkA_0kNe"))
                .body("'address'", containsString("y"))
                .body("'beds'", numberMatches(547.0))
                .body("'availableBeds'", numberMatches(0.0))
                .body("'longitude'", containsString("12.674297"))
                .body("'latitude'", containsString("42.6384261"));
        location_hospitais = "/v1/hospitais/" + "/" + res_0.extract().body().path("id").toString();
        
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .delete(resolveLocation(location_hospitais, baseUrlOfSut + "/v1/hospitais/Te2"))
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Hospital apagado id: 665a32d7747054613c92fd97"));
        
    }


}