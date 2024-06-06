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
 * This file was automatically generated by EvoMaster on 2024-06-02T11:37:05.106+02:00[Europe/Paris]
 * <br>
 * The generated test suite contains 16 tests
 * <br>
 * Covered targets: 520
 * <br>
 * Used time: 1h 2m 36s
 * <br>
 * Needed budget for current results: 94%
 * <br>
 * This file contains test cases that are likely to indicate faults.
 */
public class EvoMaster_faults_Test {

    
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
        controller.resetDatabase(Arrays.asList("CONTRIBUTOR","PROJECT","LANGUAGE_LIST","MAINTAINERS","STATISTICS"));
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
                .header("x-EMextraHeader123", "")
                .header("X-Organizations", "TxZKtJg17")
                .get(baseUrlOfSut + "/contributors?" + 
                    "organizations=jkyw&" + 
                    "offset=-1073741421&" + 
                    "start_date=LH07b2Luyz&" + 
                    "sortBy=iprjP0U6ZqMe")
                .then()
                .statusCode(500) // org/zalando/catwatch/backend/web/ContributorsApi_215_validate
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'exception'", containsString("java.lang.IllegalArgumentException"))
                .body("'message'", containsString("offset must be greater than zero but was -1073741421"))
                .body("'path'", containsString("/contributors"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_1_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_2
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_1_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/languages?" + 
                    "organizations=_EM_28_XYZ_&" + 
                    "limit=314&" + 
                    "offset=1277580520&" + 
                    "q=_EM_29_XYZ_&" + 
                    "EMextraParam123=_EM_30_XYZ_")
                .then()
                .statusCode(500) // org/zalando/catwatch/backend/service/LanguageService_49_getMainLanguages
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'exception'", containsString("java.lang.NullPointerException"))
                .body("'message'", containsString("No message available"))
                .body("'path'", containsString("/languages"));
        
        expectationHandler.expect(ems)
            // WARNING: the code list seems to contain an unsupported code (0 is not a valid HTTP code). This could indicate a problem with the schema. The issue has been logged.
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
    * [test_3_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_1
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_3_with500() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("STATISTICS", 25L)
                .d("ID", "275")
                .d("SNAPSHOT_DATE", "\"1948-08-23 19:31:25\"")
                .d("ALL_CONTRIBUTORS_COUNT", "NULL")
                .d("ALL_FORKS_COUNT", "347")
                .d("ALL_SIZE_COUNT", "NULL")
                .d("ALL_STARS_COUNT", "472")
                .d("MEMBERS_COUNT", "428")
                .d("ORGANIZATION_NAME", "NULL")
                .d("PRIVATE_PROJECT_COUNT", "858")
                .d("PROGRAM_LANGUAGES_COUNT", "NULL")
                .d("PUBLIC_PROJECT_COUNT", "NULL")
                .d("TAGS_COUNT", "NULL")
                .d("TEAMS_COUNT", "569")
                .d("EXTERNAL_CONTRIBUTORS_COUNT", "481")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_11_XYZ_")
                .get(baseUrlOfSut + "/statistics/projects")
                .then()
                .statusCode(500) // org/zalando/catwatch/backend/web/StatisticsApi_132_statisticsProjectGet
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'exception'", containsString("java.lang.IndexOutOfBoundsException"))
                .body("'message'", containsString("toIndex = 10"))
                .body("'path'", containsString("/statistics/projects"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_4_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_2
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_4_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_699_XYZ_")
                .get(baseUrlOfSut + "/projects?" + 
                    "organizations=_EM_694_XYZ_&" + 
                    "start_date=1964-04-03T00%3A53%3A26&" + 
                    "end_date=2076-07-17T17%3A55%3A05&" + 
                    "EMextraParam123=_EM_698_XYZ_")
                .then()
                .statusCode(500) // org/zalando/catwatch/backend/service/ProjectServiceImpl_113_convertProjectsToMap
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
    * [test_5_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_2
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_5_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/projects?" + 
                    "limit=695&" + 
                    "offset=698&" + 
                    "end_date=1916-01-03T20%3A23%3A57&" + 
                    "q=DsqGtNLEs&" + 
                    "EMextraParam123=42")
                .then()
                .statusCode(500) // org/zalando/catwatch/backend/service/ProjectServiceImpl_59_findProjects
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
    * [test_6_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_1
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_6_with500() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("PROJECT", 23L)
                .d("COMMITS_COUNT", "645")
                .d("CONTRIBUTORS_COUNT", "NULL")
                .d("DESCRIPTION", "\"_EM_811_XYZ_\"")
                .d("FORKS_COUNT", "166")
                .d("GIT_HUB_PROJECT_ID", "-1319557206825805790")
                .d("LAST_PUSHED", "NULL")
                .d("NAME", "\"cn4d\"")
                .d("ORGANIZATION_NAME", "\"G8Y82BNP8FS8oVd\"")
                .d("PRIMARY_LANGUAGE", "\"_EM_813_XYZ_\"")
                .d("SCORE", "NULL")
                .d("SNAPSHOT_DATE", "NULL")
                .d("STARS_COUNT", "NULL")
                .d("URL", "\"_EM_814_XYZ_\"")
                .d("TITLE", "NULL")
                .d("IMAGE", "NULL")
                .d("EXTERNAL_CONTRIBUTORS_COUNT", "NULL")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_819_XYZ_")
                .get(baseUrlOfSut + "/statistics/projects?organizations=G8Y82BNP8FS8oVd")
                .then()
                .statusCode(500) // org/zalando/catwatch/backend/web/StatisticsApi_132_statisticsProjectGet
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'exception'", containsString("java.lang.IndexOutOfBoundsException"))
                .body("'message'", containsString("toIndex = 10"))
                .body("'path'", containsString("/statistics/projects"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_7_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_1
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_7_with500() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("CONTRIBUTOR", 10L)
                .d("ID", "-801241260")
                .d("ORGANIZATION_ID", "635")
                .d("SNAPSHOT_DATE", "\"1924-07-11 07:05:21\"")
                .d("NAME", "\"Phw\"")
                .d("ORGANIZATION_NAME", "NULL")
                .d("ORGANIZATIONAL_COMMITS_COUNT", "NULL")
                .d("ORGANIZATIONAL_PROJECTS_COUNT", "70")
                .d("PERSONAL_COMMITS_COUNT", "19")
                .d("PERSONAL_PROJECTS_COUNT", "434")
                .d("URL", "\"_EM_412_XYZ_\"")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/statistics/contributors?" + 
                    "organizations=635&" + 
                    "EMextraParam123=_EM_415_XYZ_")
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
    * [test_8_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_2
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_8_with500() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("PROJECT", 74L)
                .d("COMMITS_COUNT", "41")
                .d("CONTRIBUTORS_COUNT", "NULL")
                .d("DESCRIPTION", "NULL")
                .d("FORKS_COUNT", "665")
                .d("GIT_HUB_PROJECT_ID", "261")
                .d("LAST_PUSHED", "\"_EM_1794_XYZ_\"")
                .d("NAME", "NULL")
                .d("ORGANIZATION_NAME", "NULL")
                .d("PRIMARY_LANGUAGE", "NULL")
                .d("SCORE", "107")
                .d("SNAPSHOT_DATE", "NULL")
                .d("STARS_COUNT", "378")
                .d("URL", "\"G5eLZV1K7Kw\"")
                .d("TITLE", "NULL")
                .d("IMAGE", "NULL")
                .d("EXTERNAL_CONTRIBUTORS_COUNT", "785")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .header("X-Organizations", "_EM_1799_XYZ_")
                .get(baseUrlOfSut + "/projects?" + 
                    "offset=456&" + 
                    "start_date=1999-05-12T07%3A04%3A14")
                .then()
                .statusCode(500) // org/zalando/catwatch/backend/service/ProjectServiceImpl_113_convertProjectsToMap
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
    * [test_9_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_9_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/projects?" + 
                    "organizations=&" + 
                    "offset=-32416&" + 
                    "sortBy=_EM_695_XYZ_&" + 
                    "language=_EM_697_XYZ_")
                .then()
                .statusCode(500) // org/zalando/catwatch/backend/service/ProjectServiceImpl_71_findProjects
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'exception'", containsString("java.lang.IllegalArgumentException"))
                .body("'message'", containsString("-32416"))
                .body("'path'", containsString("/projects"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_10_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_1
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_10_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/statistics/contributors")
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
    * [test_11_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_11_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_20_XYZ_")
                .get(baseUrlOfSut + "/contributors?" + 
                    "organizations=_EM_14_XYZ_&" + 
                    "limit=416&" + 
                    "offset=636&" + 
                    "end_date=_EM_16_XYZ_&" + 
                    "sortBy=_EM_17_XYZ_&" + 
                    "q=_EM_18_XYZ_&" + 
                    "EMextraParam123=_EM_19_XYZ_")
                .then()
                .statusCode(500) // org/zalando/catwatch/backend/web/ContributorsApi_221_validate
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'exception'", containsString("java.lang.IllegalArgumentException"))
                .body("'message'", containsString("sortBy must be empty or have a valid value but was _EM_17_XYZ_. Valid values are organizationalCommitsCount,organizationalProjectsCount,personalCommitsCount,personalProjectsCount,organizationName,name"))
                .body("'path'", containsString("/contributors"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_12_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_12_with500() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("CONTRIBUTOR", 41L)
                .d("ID", "526")
                .d("ORGANIZATION_ID", "919")
                .d("SNAPSHOT_DATE", "\"2074-06-20 22:01:38\"")
                .d("NAME", "NULL")
                .d("ORGANIZATION_NAME", "\"_EM_1036_XYZ_\"")
                .d("ORGANIZATIONAL_COMMITS_COUNT", "16414")
                .d("ORGANIZATIONAL_PROJECTS_COUNT", "4989")
                .d("PERSONAL_COMMITS_COUNT", "733")
                .d("PERSONAL_PROJECTS_COUNT", "-1031003885")
                .d("URL", "\"_EM_1037_XYZ_\"")
            .and().insertInto("PROJECT", 42L)
                .d("COMMITS_COUNT", "NULL")
                .d("CONTRIBUTORS_COUNT", "890")
                .d("DESCRIPTION", "\"_EM_1751_XYZ_\"")
                .d("FORKS_COUNT", "873")
                .d("GIT_HUB_PROJECT_ID", "-7330083136983397065")
                .d("LAST_PUSHED", "\"_EM_1038_XYZ_\"")
                .d("NAME", "NULL")
                .d("ORGANIZATION_NAME", "\"_EM_1750_XYZ_\"")
                .d("PRIMARY_LANGUAGE", "\"iX7bZ5\"")
                .d("SCORE", "NULL")
                .d("SNAPSHOT_DATE", "NULL")
                .d("STARS_COUNT", "-15736")
                .d("URL", "\"_EM_1040_XYZ_\"")
                .d("TITLE", "NULL")
                .d("IMAGE", "NULL")
                .d("EXTERNAL_CONTRIBUTORS_COUNT", "-261568")
            .and().insertInto("STATISTICS", 43L)
                .d("ID", "22")
                .d("SNAPSHOT_DATE", "\"1944-03-06 14:48:49\"")
                .d("ALL_CONTRIBUTORS_COUNT", "0")
                .d("ALL_FORKS_COUNT", "940")
                .d("ALL_SIZE_COUNT", "113")
                .d("ALL_STARS_COUNT", "5026")
                .d("MEMBERS_COUNT", "NULL")
                .d("ORGANIZATION_NAME", "\"_EM_1750_XYZ_\"")
                .d("PRIVATE_PROJECT_COUNT", "344481146")
                .d("PROGRAM_LANGUAGES_COUNT", "194")
                .d("PUBLIC_PROJECT_COUNT", "754")
                .d("TAGS_COUNT", "-32405")
                .d("TEAMS_COUNT", "911")
                .d("EXTERNAL_CONTRIBUTORS_COUNT", "239")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/contributors?" + 
                    "organizations=&" + 
                    "limit=977&" + 
                    "start_date=1922-02-10T14%3A22%3A12&" + 
                    "q=FDd7BQmVBCR4Y%7D")
                .then()
                .statusCode(500) // org/zalando/catwatch/backend/web/config/DateUtil_15_iso8601
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(500.0))
                .body("'error'", containsString("Internal Server Error"))
                .body("'exception'", containsString("java.lang.RuntimeException"))
                .body("'message'", containsString("java.text.ParseException: Unparseable date: \"1922-02-10T14:22:12\""))
                .body("'path'", containsString("/contributors"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_13_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_13_with500() throws Exception {
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
    
    
    /**
    * [test_14_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_14_with500() throws Exception {
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
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_15_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_15_with500() throws Exception {
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


}
