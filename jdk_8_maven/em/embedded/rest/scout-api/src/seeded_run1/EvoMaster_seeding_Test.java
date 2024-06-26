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
 * This file was automatically generated by EvoMaster on 2024-05-29T04:52:44.448+02:00[Europe/Paris]
 * <br>
 * The generated test suite contains 35 tests
 * <br>
 * Covered targets: 286
 * <br>
 * Used time: 2h 0m 43s
 * <br>
 * Needed budget for current results: 99%
 * <br>
 * This file contains test cases generated during seeding.
 */
public class EvoMaster_seeding_Test {

    
    private static final SutHandler controller = new em.embedded.se.devscout.scoutapi.EmbeddedEvoMasterController();
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
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/v1/media_files/3/file?EMextraParam123=42")
                .then()
                .statusCode(500) // se/devscout/scoutapi/resource/MediaFileResource_260_downloadFile
                .assertThat()
                .contentType("application/json")
                .body("'code'", numberMatches(500.0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_1() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/v1/system_messages/1?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body(containsString("null"));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_2() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/v1/media_files/4?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body(containsString("null"));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_3() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/v2/tags?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_4() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/v1/system_messages?" + 
                    "key=a.&" + 
                    "valid=now&" + 
                    "EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_5() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/v2/activities/5?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body(containsString("null"));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_6() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/v1/media_files?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_7() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/v1/system_messages?" + 
                    "key=b&" + 
                    "EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_8() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/v1/system_messages?" + 
                    "key=a.&" + 
                    "valid=now_and_future&" + 
                    "EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_9() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/v2/tags/1?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body(containsString("null"));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_10() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/v1/system/roles?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'permission_levels'.'category_edit'", numberMatches(10.0))
                .body("'permission_levels'.'mediaitem_create'", numberMatches(10.0))
                .body("'permission_levels'.'reference_edit_own'", numberMatches(0.0))
                .body("'permission_levels'.'system_message_read'", numberMatches(-100.0))
                .body("'permission_levels'.'auth_role_list'", numberMatches(20.0))
                .body("'permission_levels'.'reference_edit'", numberMatches(10.0))
                .body("'permission_levels'.'auth_user_create'", numberMatches(20.0))
                .body("'permission_levels'.'activity_edit_own'", numberMatches(0.0))
                .body("'permission_levels'.'comment_create'", numberMatches(0.0))
                .body("'permission_levels'.'category_create'", numberMatches(10.0))
                .body("'permission_levels'.'activity_edit'", numberMatches(10.0))
                .body("'permission_levels'.'reference_create'", numberMatches(10.0))
                .body("'permission_levels'.'mediaitem_edit'", numberMatches(10.0))
                .body("'permission_levels'.'auth_user_edit'", numberMatches(20.0))
                .body("'permission_levels'.'auth_profile_edit'", numberMatches(0.0))
                .body("'permission_levels'.'comment_edit'", numberMatches(10.0))
                .body("'permission_levels'.'system_message_manage'", numberMatches(20.0))
                .body("'permission_levels'.'mediaitem_edit_own'", numberMatches(0.0))
                .body("'permission_levels'.'auth_role_assignown'", numberMatches(10.0))
                .body("'permission_levels'.'rating_set_own'", numberMatches(0.0))
                .body("'permission_levels'.'auth_role_assign'", numberMatches(20.0))
                .body("'permission_levels'.'comment_edit_own'", numberMatches(0.0))
                .body("'permission_levels'.'activity_create'", numberMatches(0.0))
                .body("'role_levels'.'administrator'", numberMatches(20.0))
                .body("'role_levels'.'moderator'", numberMatches(10.0))
                .body("'role_levels'.'limited_user'", numberMatches(-1.0))
                .body("'role_levels'.'user'", numberMatches(0.0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_11() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/v2/activities?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_12() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/v1/system/ping?EMextraParam123=42")
                .then()
                .statusCode(204)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_13() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/v1/users/1?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_14() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/v1/users?" + 
                    "attrs=id%2Cidentities&" + 
                    "EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_15() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .delete(baseUrlOfSut + "/api/v1/users/4?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_16() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .delete(baseUrlOfSut + "/api/v2/tags/6?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_17() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .delete(baseUrlOfSut + "/api/v1/system_messages/1?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_18() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .delete(baseUrlOfSut + "/api/v1/media_files/4?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_19() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .delete(baseUrlOfSut + "/api/v2/activities/5/rating?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_20() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"rating\": 5, " + 
                    " \"favourite\": false " + 
                    " } ")
                .post(baseUrlOfSut + "/api/v2/activities/5/rating?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_21() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": [ " + 
                    " 2, " + 
                    " 4 " + 
                    " ] " + 
                    " } ")
                .post(baseUrlOfSut + "/api/v1/favourites?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_22() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .delete(baseUrlOfSut + "/api/v2/activities/1?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_23() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": 1, " + 
                    " \"name\": \"Don\u0027t care about the name\", " + 
                    " \"authorization_level\": 99, " + 
                    " \"identities\": [ " + 
                    " { " + 
                    " \"id\": 0, " + 
                    " \"date_created\": \"2024-05-26T19:24:08\", " + 
                    " \"type\": \"API\", " + 
                    " \"value\": \"some api key\" " + 
                    " } " + 
                    " ] " + 
                    " } ")
                .put(baseUrlOfSut + "/api/v1/users/1?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_24() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": 0, " + 
                    " \"name\": \"new user\", " + 
                    " \"authorization_level\": 0, " + 
                    " \"identities\": [ " + 
                    " { " + 
                    " \"id\": 0, " + 
                    " \"date_created\": \"2024-05-26T19:24:08\", " + 
                    " \"type\": \"API\", " + 
                    " \"value\": \"some api key\" " + 
                    " } " + 
                    " ] " + 
                    " } ")
                .post(baseUrlOfSut + "/api/v1/users?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_25() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/v1/users/profile?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_26() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": 0, " + 
                    " \"name\": \"A New Activity\", " + 
                    " \"date_created\": \"2024-05-26T19:24:07\", " + 
                    " \"description_material\": \"Materials\", " + 
                    " \"description_introduction\": \"Introduction\", " + 
                    " \"description_prepare\": \"Preparations\", " + 
                    " \"description_main\": \"Main\", " + 
                    " \"description_safety\": \"Safety\", " + 
                    " \"description_notes\": \"Notes\", " + 
                    " \"age_min\": 5, " + 
                    " \"age_max\": 10, " + 
                    " \"participants_min\": 1, " + 
                    " \"participants_max\": 3, " + 
                    " \"time_min\": 10, " + 
                    " \"time_max\": 30, " + 
                    " \"featured\": false, " + 
                    " \"tags\": [ " + 
                    " { " + 
                    " \"id\": 1, " + 
                    " \"activities_count\": 0 " + 
                    " }, " + 
                    " { " + 
                    " \"id\": 0, " + 
                    " \"group\": \"location\", " + 
                    " \"name\": \"At home\", " + 
                    " \"activities_count\": 0 " + 
                    " } " + 
                    " ], " + 
                    " \"media_files\": [ " + 
                    " { " + 
                    " \"id\": 0, " + 
                    " \"mime_type\": \"image/gif\", " + 
                    " \"uri\": \"http://example.com/ant.gif\", " + 
                    " \"name\": \"ant.gif\" " + 
                    " }, " + 
                    " { " + 
                    " \"id\": 0, " + 
                    " \"mime_type\": \"image/gif\", " + 
                    " \"uri\": \"http://example.com/ant.gif\", " + 
                    " \"name\": \"ant.gif - Duplicate which should not be persisted\" " + 
                    " }, " + 
                    " { " + 
                    " \"id\": 0, " + 
                    " \"mime_type\": \"image/gif\", " + 
                    " \"uri\": \"http://example.com/bobcat.gif\", " + 
                    " \"name\": \"bobcat.gif\" " + 
                    " } " + 
                    " ] " + 
                    " } ")
                .post(baseUrlOfSut + "/api/v2/activities?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_27() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": 0, " + 
                    " \"group\": \"G\", " + 
                    " \"name\": \"N\", " + 
                    " \"activities_count\": 0 " + 
                    " } ")
                .post(baseUrlOfSut + "/api/v2/tags?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_28() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": 1, " + 
                    " \"key\": \"fail\", " + 
                    " \"value\": \"fail\", " + 
                    " \"valid_to\": \"2024-05-26T21:24:06\", " + 
                    " \"valid_from\": \"2024-05-26T22:24:06\" " + 
                    " } ")
                .put(baseUrlOfSut + "/api/v1/system_messages/1?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_29() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": 0, " + 
                    " \"key\": \"fail\", " + 
                    " \"value\": \"fail\", " + 
                    " \"valid_to\": \"2024-05-26T21:24:06\", " + 
                    " \"valid_from\": \"2024-05-26T22:24:06\" " + 
                    " } ")
                .post(baseUrlOfSut + "/api/v1/system_messages?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_30() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": 4, " + 
                    " \"mime_type\": \"image/gif\", " + 
                    " \"uri\": \"http://example.com/profile-bob.gif\", " + 
                    " \"name\": \"Bob\u0027s Profile Picture\" " + 
                    " } ")
                .put(baseUrlOfSut + "/api/v1/media_files/4?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_31() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": 0, " + 
                    " \"mime_type\": \"image/jpeg\", " + 
                    " \"uri\": \"http://example.com/profile-alice.jpg\", " + 
                    " \"name\": \"Alice\u0027s Profile Picture\" " + 
                    " } ")
                .post(baseUrlOfSut + "/api/v1/media_files?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_32() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/v1/favourites?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_33() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": 1, " + 
                    " \"name\": \"An Updated Activity\", " + 
                    " \"date_created\": \"2024-05-26T19:24:00\", " + 
                    " \"description_material\": \"Materials\", " + 
                    " \"description_introduction\": \"The Introduction Has Been Updated\", " + 
                    " \"description_prepare\": \"Preparations\", " + 
                    " \"description_main\": \"Main\", " + 
                    " \"description_safety\": \"Safety\", " + 
                    " \"description_notes\": \"Notes\", " + 
                    " \"age_min\": 5, " + 
                    " \"age_max\": 10, " + 
                    " \"participants_min\": 1, " + 
                    " \"participants_max\": 3, " + 
                    " \"time_min\": 10, " + 
                    " \"time_max\": 30, " + 
                    " \"featured\": false, " + 
                    " \"tags\": [ " + 
                    " { " + 
                    " \"id\": 1, " + 
                    " \"activities_count\": 0 " + 
                    " } " + 
                    " ], " + 
                    " \"media_files\": [ " + 
                    " { " + 
                    " \"id\": 0, " + 
                    " \"mime_type\": \"image/gif\", " + 
                    " \"uri\": \"http://example.com/bobcat.gif\", " + 
                    " \"name\": \"bobcat.gif\" " + 
                    " } " + 
                    " ] " + 
                    " } ")
                .put(baseUrlOfSut + "/api/v2/activities/1?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_34() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": 1, " + 
                    " \"name\": \"A Patched Activity\", " + 
                    " \"date_created\": \"2024-05-26T19:24:00\" " + 
                    " } ")
                .patch(baseUrlOfSut + "/api/v2/activities/1?EMextraParam123=42")
                .then()
                .statusCode(401)
                .assertThat()
                .contentType("text/plain")
                .body(containsString("Credentials are required to access this resource."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }


}
