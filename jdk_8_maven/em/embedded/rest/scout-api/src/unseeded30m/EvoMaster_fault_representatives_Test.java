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
import static org.evomaster.client.java.sql.dsl.SqlDsl.sql;
import  org.evomaster.client.java.controller.api.dto.database.operations.InsertionResultsDto;
import  org.evomaster.client.java.controller.api.dto.database.operations.InsertionDto;
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
 * This file was automatically generated by EvoMaster on 2024-05-26T22:38:39.040+02:00[Europe/Paris]
 * <br>
 * The generated test suite contains 4 tests
 * <br>
 * Covered targets: 620
 * <br>
 * Used time: 0h 30m 26s
 * <br>
 * Needed budget for current results: 99%
 * <br>
 * This file contains one example of each category of fault. The test cases in this file are a subset of the set of test cases likely to indicate faults.
 */
public class EvoMaster_fault_representatives_Test {

    
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
        controller.resetDatabase(Arrays.asList("USERS","ACTIVITY_PROPERTIES","ACTIVITY_PROPERTIES_MEDIA_FILE","ACTIVITY_PROPERTIES_TAG","ACTIVITY_RATING","ACTIVITY_RELATION","USER_IDENTITY","ACTIVITY","ACTIVITY_DERIVED","MEDIA_FILE","MEDIA_FILE_KEYWORDS","TAG","TAG_DERIVED"));
        controller.resetStateOfSUT();
    }
    
    
    
    
    /**
    * [test_0_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_0_with500() throws Exception {
        
        given().accept("*/*")
                .header("Authorization", "ApiKey user") // user
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/v2/activities/83/rating")
                .then()
                .statusCode(500) // se/devscout/scoutapi/model/ActivityRating$Key_90_<init>
                .assertThat()
                .contentType("application/json")
                .body("'code'", numberMatches(500.0));
        
    }
    
    
    /**
    * [test_1_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_1_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("Authorization", "ApiKey administrator") // administrator
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": 859, " + 
                    " \"email_address\": \"_EM_6455_XYZ_\", " + 
                    " \"identities\": [ " + 
                    " { " + 
                    " \"id\": -991659468281709235, " + 
                    " \"type\": \"API\", " + 
                    " \"value\": \"_EM_6456_XYZ_\" " + 
                    " } " + 
                    " ] " + 
                    " } ")
                .post(baseUrlOfSut + "/api/v1/users")
                .then()
                .statusCode(500) // se/devscout/scoutapi/resource/UserResource_62_create
                .assertThat()
                .contentType("application/json")
                .body("'code'", numberMatches(500.0));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_2_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_1
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_2_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("Authorization", "ApiKey moderator") // moderator
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"mime_type\": \"CAPTURE_DATE\", " + 
                    " \"uri\": \"data:;base64,aWlzejd5UE43\", " + 
                    " \"copy_right\": \"_EM_3320_XYZ_\" " + 
                    " } ")
                .post(baseUrlOfSut + "/api/v1/media_files")
                .then()
                .statusCode(500) // se/devscout/scoutapi/resource/MediaFileResource_135_create
                .assertThat()
                .contentType("application/json")
                .body("'code'", numberMatches(500.0))
                .body("'message'", containsString("HTTP 500 Internal Server Error"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_3_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_3_with500() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("ACTIVITY", 2054L)
            .and().insertInto("ACTIVITY", 2055L)
            .and().insertInto("ACTIVITY", 2056L)
            .and().insertInto("ACTIVITY", 2057L)
            .and().insertInto("ACTIVITY", 2058L)
            .and().insertInto("ACTIVITY", 1802L)
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("Authorization", "ApiKey administrator") // administrator
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": 936, " + 
                    " \"description_material\": \"4pU\", " + 
                    " \"description_main\": \"4pU\", " + 
                    " \"description_safety\": \"4pU\", " + 
                    " \"age_min\": -2147482776, " + 
                    " \"age_max\": -2147482776, " + 
                    " \"participants_min\": 792, " + 
                    " \"featured\": false, " + 
                    " \"tags\": [ " + 
                    " { " + 
                    " \"group\": \"AG648Tp_zss0VBU\", " + 
                    " \"name\": \"yW9xMzqw3E\" " + 
                    " } " + 
                    " ], " + 
                    " \"media_files\": [ " + 
                    " { " + 
                    " \"uri\": \"4kV\", " + 
                    " \"name\": \"OpqO\", " + 
                    " \"copy_right\": \"6PncTpg6AwKPBKA\", " + 
                    " \"author\": \"8Ql7\" " + 
                    " } " + 
                    " ], " + 
                    " \"activity\": { " + 
                    " \"id\": 327, " + 
                    " \"properties_revisions\": [], " + 
                    " \"ratings_sum\": 367, " + 
                    " \"favourites_count\": 914, " + 
                    " \"ratings_average\": 0.051700101248575714 " + 
                    " } " + 
                    " } ")
                .post(baseUrlOfSut + "/api/v2/activities")
                .then()
                .statusCode(500) // se/devscout/scoutapi/model/ActivityPropertiesMediaFile_72_hashCode
                .assertThat()
                .contentType("application/json")
                .body("'code'", numberMatches(500.0));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }


}
