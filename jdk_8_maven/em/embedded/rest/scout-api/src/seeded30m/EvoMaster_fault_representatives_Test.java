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
 * This file was automatically generated by EvoMaster on 2024-05-26T22:03:35.645+02:00[Europe/Paris]
 * <br>
 * The generated test suite contains 4 tests
 * <br>
 * Covered targets: 597
 * <br>
 * Used time: 0h 30m 17s
 * <br>
 * Needed budget for current results: 97%
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
        controller.resetDatabase(Arrays.asList("MEDIA_FILE","ACTIVITY_PROPERTIES_MEDIA_FILE","MEDIA_FILE_KEYWORDS","TAG","ACTIVITY_PROPERTIES_TAG","TAG_DERIVED","USERS","ACTIVITY_PROPERTIES","ACTIVITY_RATING","ACTIVITY_RELATION","USER_IDENTITY","ACTIVITY","ACTIVITY_DERIVED"));
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
                .header("Authorization", "ApiKey administrator") // administrator
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"name\": \"\", " + 
                    " \"email_address\": \"FKY\" " + 
                    " } ")
                .put(baseUrlOfSut + "/api/v1/users/888")
                .then()
                .statusCode(500) // se/devscout/scoutapi/resource/UserResource_100_update
                .assertThat()
                .contentType("application/json")
                .body("'code'", numberMatches(500.0));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_1_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_1
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_1_with500() throws Exception {
        
        String location_media_files = "";
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("Authorization", "ApiKey administrator") // administrator
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"mime_type\": \"VALID_FROM\", " + 
                    " \"uri\": \"http://:699/eHtTTtQq_0Rsd0/It4HR8l7z\", " + 
                    " \"copy_right\": \"_EM_11057_XYZ_\" " + 
                    " } ")
                .post(baseUrlOfSut + "/api/v1/media_files")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'mime_type'", containsString("VALID_FROM"))
                .body("'uri'", containsString("http://:699/eHtTTtQq_0Rsd0/It4HR8l7z"))
                .body("'copy_right'", containsString("_EM_11057_XYZ_"));
        location_media_files = "/api/v1/media_files" + "/" + res_0.extract().body().path("id").toString();
        
        
        given().accept("*/*")
                .header("Authorization", "ApiKey administrator") // administrator
                .header("x-EMextraHeader123", "")
                .get(resolveLocation(location_media_files, baseUrlOfSut + "/api/v1/media_files/535/file"))
                .then()
                .statusCode(500) // se/devscout/scoutapi/resource/MediaFileResource_279_downloadFile
                .assertThat()
                .contentType("application/json")
                .body("'code'", numberMatches(500.0))
                .body("'message'", containsString("HTTP 500 Internal Server Error"));
        
    }
    
    
    /**
    * [test_2_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_2_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("Authorization", "ApiKey user") // user
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"name\": \"_EM_2209_XYZ_\", " + 
                    " \"description_prepare\": \"_EM_2212_XYZ_\", " + 
                    " \"description_main\": \"_EM_2213_XYZ_\", " + 
                    " \"description_safety\": \"SFAnhCbni\", " + 
                    " \"description_notes\": \"_EM_2214_XYZ_\", " + 
                    " \"participants_min\": 688, " + 
                    " \"participants_max\": 493, " + 
                    " \"time_min\": 741, " + 
                    " \"time_max\": 345, " + 
                    " \"tags\": [ " + 
                    " { " + 
                    " \"name\": \"_EM_2216_XYZ_\", " + 
                    " \"media_file\": { " + 
                    " \"id\": 789, " + 
                    " \"name\": \"_EM_2219_XYZ_\", " + 
                    " \"copy_right\": \"_EM_2220_XYZ_\", " + 
                    " \"author\": \"_EM_2221_XYZ_\" " + 
                    " }, " + 
                    " \"activities_count\": -6398975898283859301 " + 
                    " } " + 
                    " ], " + 
                    " \"author\": { " + 
                    " \"name\": \"_EM_2242_XYZ_\" " + 
                    " }, " + 
                    " \"activity\": { " + 
                    " \"ratings_count\": 71, " + 
                    " \"ratings_sum\": 645 " + 
                    " } " + 
                    " } ")
                .post(baseUrlOfSut + "/api/v2/activities?EMextraParam123=42")
                .then()
                .statusCode(500) // se/devscout/scoutapi/dao/ActivityDao_197_lambda$initTags$7
                .assertThat()
                .contentType("application/json")
                .body("'code'", numberMatches(500.0));
        
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
        List<InsertionDto> insertions = sql().insertInto("MEDIA_FILE", 1704L)
                .d("URI", "\"_EM_19054_XYZ_\"")
            .and().insertInto("TAG", 1703L)
                .d("GRP", "\"950917\"")
                .d("NAME", "\"_EM_19055_XYZ_\"")
                .r("MEDIA_FILE_ID", 1704L)
            .and().insertInto("USERS", 4435L)
                .d("AUTHORIZATION_LEVEL", "292")
                .d("NAME", "\"hhP8PRRfZ618Fzxi\"")
            .and().insertInto("ACTIVITY", 4434L)
            .and().insertInto("ACTIVITY", 4433L)
            .and().insertInto("ACTIVITY_PROPERTIES", 4432L)
                .d("AGE_MAX", "-2147450592")
                .d("AGE_MIN", "NULL")
                .d("DATE_CREATED", "NULL")
                .d("DATE_PUBLISHED", "NULL")
                .d("DATE_UPDATED", "\"1943-03-08 05:41:27\"")
                .d("DESCRIPTION_INTRODUCTION", "\"7\"")
                .d("DESCRIPTION_MAIN", "\"_EM_31438_XYZ_\"")
                .d("DESCRIPTION_MATERIAL", "\"1032980\"")
                .d("DESCRIPTION_NOTES", "\"SlCENww\"")
                .d("DESCRIPTION_PREPARE", "\"OlN7Pr\"")
                .d("DESCRIPTION_SAFETY", "\"jJasoiTxdj67db\"")
                .d("FEATURED", "false")
                .d("NAME", "\"gcUly6S6cF3HYm\"")
                .d("PARTICIPANTS_MAX", "24")
                .d("PARTICIPANTS_MIN", "214")
                .d("SOURCE", "\"\"")
                .d("TIME_MAX", "0")
                .d("TIME_MIN", "852")
                .r("ACTIVITY_ID", 4433L)
                .d("AUTHOR_ID", "3")
                .r("PUBLISHING_ACTIVITY_ID", 4433L)
            .and().insertInto("USERS", 4439L)
                .d("AUTHORIZATION_LEVEL", "42")
                .d("NAME", "\"4KdypsLGZU\"")
            .and().insertInto("ACTIVITY", 4438L)
            .and().insertInto("ACTIVITY", 4437L)
            .and().insertInto("ACTIVITY_PROPERTIES", 4436L)
                .d("AGE_MAX", "NULL")
                .d("AGE_MIN", "NULL")
                .d("DATE_CREATED", "\"2061-04-27 02:33:15\"")
                .d("DATE_PUBLISHED", "\"1967-06-16 17:02:29\"")
                .d("DATE_UPDATED", "\"2040-10-09 21:18:51\"")
                .d("DESCRIPTION_INTRODUCTION", "\"V\"")
                .d("DESCRIPTION_MAIN", "\"FdnzTAwXB\"")
                .d("DESCRIPTION_MATERIAL", "\"M3Hi\"")
                .d("DESCRIPTION_NOTES", "\"U\"")
                .d("DESCRIPTION_PREPARE", "\"2\"")
                .d("DESCRIPTION_SAFETY", "\"M4RddO\"")
                .d("FEATURED", "true")
                .d("NAME", "\"N\"")
                .d("PARTICIPANTS_MAX", "368")
                .d("PARTICIPANTS_MIN", "NULL")
                .d("SOURCE", "NULL")
                .d("TIME_MAX", "732")
                .d("TIME_MIN", "590")
                .r("ACTIVITY_ID", 4433L)
                .r("AUTHOR_ID", 4439L)
                .r("PUBLISHING_ACTIVITY_ID", 4434L)
            .and().insertInto("MEDIA_FILE", 9329L)
                .d("URI", "\"64PjCTyBu3qKKHL\"")
            .and().insertInto("TAG", 9328L)
                .d("GRP", "\"YDJj\"")
                .d("NAME", "\"_EM_31432_XYZ_\"")
            .and().insertInto("USERS", 9327L)
                .d("AUTHORIZATION_LEVEL", "0")
                .d("NAME", "\"Lzv\"")
            .and().insertInto("ACTIVITY", 9326L)
            .and().insertInto("ACTIVITY", 9325L)
            .and().insertInto("ACTIVITY_PROPERTIES", 9324L)
                .r("ACTIVITY_ID", 4437L)
            .and().insertInto("ACTIVITY_PROPERTIES_TAG", 9323L)
                .r("ACTIVITY_PROPERTIES_ID", 4436L)
                .r("TAG_ID", 9328L)
            .and().insertInto("MEDIA_FILE", 9336L)
                .d("URI", "\"FROM\"")
            .and().insertInto("TAG", 9335L)
                .d("GRP", "\"mkHO8j\"")
                .d("NAME", "\"_EM_31296_XYZ_\"")
            .and().insertInto("USERS", 9334L)
                .d("AUTHORIZATION_LEVEL", "796")
                .d("NAME", "\"lr\"")
            .and().insertInto("ACTIVITY", 9333L)
            .and().insertInto("ACTIVITY", 9332L)
            .and().insertInto("ACTIVITY_PROPERTIES", 9331L)
                .r("ACTIVITY_ID", 9326L)
            .and().insertInto("ACTIVITY_PROPERTIES_TAG", 9330L)
                .r("ACTIVITY_PROPERTIES_ID", 4432L)
                .r("TAG_ID", 1703L)
            .and().insertInto("MEDIA_FILE", 9343L)
                .d("URI", "\"_EM_28991_XYZ_\"")
            .and().insertInto("TAG", 9342L)
                .d("GRP", "\"fs3D7cF9JSPpGHP\"")
                .d("NAME", "\"USER6_\"")
            .and().insertInto("USERS", 9341L)
                .d("AUTHORIZATION_LEVEL", "184")
                .d("NAME", "\"dMraT\"")
            .and().insertInto("ACTIVITY", 9340L)
            .and().insertInto("ACTIVITY", 9339L)
            .and().insertInto("ACTIVITY_PROPERTIES", 9338L)
                .r("ACTIVITY_ID", 9333L)
            .and().insertInto("ACTIVITY_PROPERTIES_TAG", 9337L)
                .r("ACTIVITY_PROPERTIES_ID", 9338L)
                .r("TAG_ID", 9328L)
            .and().insertInto("MEDIA_FILE", 9350L)
                .d("URI", "\"Rj1HoEcYG4O2GVmO\"")
            .and().insertInto("TAG", 9349L)
                .d("GRP", "\"AA_C0d9wonpNK5x\"")
                .d("NAME", "\"kKAaS0zo00CoczCZ\"")
            .and().insertInto("USERS", 9348L)
                .d("AUTHORIZATION_LEVEL", "661")
                .d("NAME", "\"K\"")
            .and().insertInto("ACTIVITY", 9347L)
            .and().insertInto("ACTIVITY", 9346L)
            .and().insertInto("ACTIVITY_PROPERTIES", 9345L)
                .r("ACTIVITY_ID", 9347L)
            .and().insertInto("ACTIVITY_PROPERTIES_TAG", 9344L)
                .r("ACTIVITY_PROPERTIES_ID", 9324L)
                .r("TAG_ID", 1703L)
            .and().insertInto("MEDIA_FILE", 9357L)
                .d("URI", "\"UUQbBXGK\"")
            .and().insertInto("TAG", 9356L)
                .d("GRP", "\"gCiDchB_ZdmpxcYa\"")
                .d("NAME", "\"5EEo46EX6_\"")
            .and().insertInto("USERS", 9355L)
                .d("AUTHORIZATION_LEVEL", "817")
                .d("NAME", "\"PPPdi\"")
            .and().insertInto("ACTIVITY", 9354L)
            .and().insertInto("ACTIVITY", 9353L)
            .and().insertInto("ACTIVITY_PROPERTIES", 9352L)
                .r("ACTIVITY_ID", 4433L)
            .and().insertInto("ACTIVITY_PROPERTIES_TAG", 9351L)
                .r("ACTIVITY_PROPERTIES_ID", 9352L)
                .r("TAG_ID", 9328L)
            .and().insertInto("MEDIA_FILE", 9372L)
                .d("URI", "\"0NCU7dZr\"")
            .and().insertInto("TAG", 9371L)
                .d("GRP", "\"_EM_29001_XYZ_\"")
                .d("NAME", "\"RAVLi4M6xb7\"")
            .and().insertInto("TAG_DERIVED", 9370L)
                .r("TAG_ID", 9349L)
                .d("ACTIVITIES_COUNT", "NULL")
            .and().insertInto("MEDIA_FILE", 9375L)
                .d("URI", "\"U\"")
            .and().insertInto("TAG", 9374L)
                .d("GRP", "\"_EM_29002_XYZ_\"")
                .d("NAME", "\"rlxwF3hjf11h5sx\"")
            .and().insertInto("TAG_DERIVED", 9373L)
                .r("TAG_ID", 9356L)
                .d("ACTIVITIES_COUNT", "NULL")
            .and().insertInto("MEDIA_FILE", 9378L)
                .d("URI", "\"tRHBfP1_\"")
            .and().insertInto("TAG", 9377L)
                .d("GRP", "\"4mOZahztNk\"")
                .d("NAME", "\"_EM_31433_XYZ_\"")
            .and().insertInto("TAG_DERIVED", 9376L)
                .r("TAG_ID", 1703L)
                .d("ACTIVITIES_COUNT", "NULL")
            .and().insertInto("MEDIA_FILE", 9381L)
                .d("URI", "\"_EM_29003_XYZ_\"")
            .and().insertInto("TAG", 9380L)
                .d("GRP", "\"V3\"")
                .d("NAME", "\"eQFAYGzn\"")
            .and().insertInto("TAG_DERIVED", 9379L)
                .r("TAG_ID", 9328L)
                .d("ACTIVITIES_COUNT", "NULL")
            .and().insertInto("MEDIA_FILE", 9384L)
                .d("URI", "\"QkBeeOH5agjdqcT\"")
            .and().insertInto("TAG", 9383L)
                .d("GRP", "\"VALID_FR3_9_0_\"")
                .d("NAME", "\"D8KBSqlnZtw\"")
            .and().insertInto("TAG_DERIVED", 9382L)
                .r("TAG_ID", 9377L)
                .d("ACTIVITIES_COUNT", "NULL")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("Authorization", "ApiKey moderator") // moderator
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": 1642479284252998622, " + 
                    " \"name\": \"_Qbbz9RpSL\", " + 
                    " \"description_material\": \"3azxqVZ3_5Z71\", " + 
                    " \"description_introduction\": \"_EM_31290_XYZ_\", " + 
                    " \"description_prepare\": \"90eXFRk8\", " + 
                    " \"description_main\": \"26OWs]nxEOc\", " + 
                    " \"description_safety\": \"YDmhrM9\", " + 
                    " \"description_notes\": \"_EM_28998_XYZ_\", " + 
                    " \"age_min\": -1077935539, " + 
                    " \"age_max\": -120, " + 
                    " \"participants_min\": -4036, " + 
                    " \"participants_max\": 1048577311, " + 
                    " \"time_min\": -671088851, " + 
                    " \"time_max\": 1759571715, " + 
                    " \"source\": \"A1\\\\I7Y\", " + 
                    " \"tags\": [ " + 
                    " { " + 
                    " \"id\": 0, " + 
                    " \"group\": \"4L0zLCISo0k5d\", " + 
                    " \"media_file\": { " + 
                    " \"id\": 89, " + 
                    " \"uri\": \"L5iMWqDWqv\", " + 
                    " \"name\": \"OqnBwOuTS9YYZ4Yt\", " + 
                    " \"copy_right\": \"bsPx42Zj\", " + 
                    " \"author\": \"gB0Fno2JcWiMvGJh\" " + 
                    " } " + 
                    " }, " + 
                    " { " + 
                    " \"id\": -314065631, " + 
                    " \"name\": \"r7_mNWbH5y\" " + 
                    " } " + 
                    " ], " + 
                    " \"media_files\": [ " + 
                    " { " + 
                    " \"mime_type\": \"\", " + 
                    " \"author\": \"S\" " + 
                    " } " + 
                    " ], " + 
                    " \"activity\": { " + 
                    " \"properties_revisions\": [], " + 
                    " \"favourites_count\": 338 " + 
                    " } " + 
                    " } ")
                .post(baseUrlOfSut + "/api/v2/activities")
                .then()
                .statusCode(500) // se/devscout/scoutapi/dao/TagDao_64_create
                .assertThat()
                .contentType("application/json")
                .body("'code'", numberMatches(500.0));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }


}
