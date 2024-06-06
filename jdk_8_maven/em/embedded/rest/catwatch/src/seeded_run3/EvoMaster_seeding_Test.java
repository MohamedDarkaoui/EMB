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
 * This file was automatically generated by EvoMaster on 2024-06-02T13:27:12.843+02:00[Europe/Paris]
 * <br>
 * The generated test suite contains 7 tests
 * <br>
 * Covered targets: 361
 * <br>
 * Used time: 1h 1m 19s
 * <br>
 * Needed budget for current results: 86%
 * <br>
 * This file contains test cases generated during seeding.
 */
public class EvoMaster_seeding_Test {

    
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
    
    
    
    
    @Test(timeout = 60000)
    public void test_0_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/contributors?" + 
                    "organizations=IBM%2CSun&" + 
                    "sortBy=personalProjectsCount&" + 
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
            // WARNING: the code list seems to contain an unsupported code (0 is not a valid HTTP code). This could indicate a problem with the schema. The issue has been logged.
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_1_with500() throws Exception {
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
            // WARNING: the code list seems to contain an unsupported code (0 is not a valid HTTP code). This could indicate a problem with the schema. The issue has been logged.
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_2_with500() throws Exception {
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
    
    
    @Test(timeout = 60000)
    public void test_3_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/contributors?" + 
                    "organizations=+IBM%2CSun&" + 
                    "start_date=2024-05-29T16%3A04%3A11Z&" + 
                    "end_date=2024-06-02T04%3A04%3A11Z&" + 
                    "EMextraParam123=42")
                .then()
                .statusCode(500) // org/zalando/catwatch/backend/web/ContributorsApi_224_validate
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'exception'", containsString("java.lang.IllegalArgumentException"))
                .body("'message'", containsString("endDate is set to 2024-06-02T04:04:11Zbut there is no snapshot data before that date"))
                .body("'path'", containsString("/contributors"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_4() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/config?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'cache.path'", containsString("target/cache"))
                .body("'cache.size'", containsString("50"))
                .body("'endpoints.enabled'", containsString("false"))
                .body("'endpoints.health.enabled'", containsString("true"))
                .body("'github.login'", nullValue())
                .body("'organization.list'", containsString("zalando,zalando-stups,zalando-incubator"))
                .body("'schedule'", containsString("0 1 8 * * *"))
                .body("'scoring.project'", containsString("function(project) {var daysSinceLastPush = 0;if (project.lastPushed) {var tokens = project.lastPushed.split(\" \");var day = tokens[2];var month = tokens[1];var year = tokens[5];var lastPushedDate = new Date(day + ' ' + month + ' ' + year);var millisInDay = 86400000;daysSinceLastPush = Math.floor((new Date() - lastPushedDate) / millisInDay);}var maintainersPenalty = 0;if (project.maintainers.length < 2) {maintainersPenalty = 100;}return project.starsCount * 3 + project.forksCount * 2 + project.contributorsCount * 5 - daysSinceLastPush - maintainersPenalty}"))
                .body("'spring.database.driverClassName'", nullValue())
                .body("'spring.datasource.platform'", nullValue())
                .body("'spring.datasource.url'", containsString("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;"))
                .body("'spring.datasource.username'", containsString("sa"))
                .body("'spring.jpa.database'", nullValue())
                .body("'spring.jpa.hibernate.ddl-auto'", containsString("update"));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_5() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/statistics?" + 
                    "organizations=organization1%2Corganization2&" + 
                    "EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_6() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/statistics?" + 
                    "organizations=organization1&" + 
                    "start_date=2024-05-29T04%3A05%3A12Z&" + 
                    "end_date=2024-05-31T04%3A04%3A12Z&" + 
                    "EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(0));
        
    }


}
