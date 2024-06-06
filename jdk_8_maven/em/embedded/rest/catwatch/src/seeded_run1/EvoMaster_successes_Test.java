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
 * This file was automatically generated by EvoMaster on 2024-06-02T10:31:26.628+02:00[Europe/Paris]
 * <br>
 * The generated test suite contains 11 tests
 * <br>
 * Covered targets: 709
 * <br>
 * Used time: 1h 5m 3s
 * <br>
 * Needed budget for current results: 63%
 * <br>
 * This file contains test cases that represent successful calls.
 */
public class EvoMaster_successes_Test {

    
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
        controller.resetDatabase(Arrays.asList("CONTRIBUTOR","STATISTICS","PROJECT","LANGUAGE_LIST","MAINTAINERS"));
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
    public void test_2() throws Exception {
        
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
    public void test_3() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("STATISTICS", 9L)
                .d("ID", "607")
                .d("SNAPSHOT_DATE", "\"1954-02-18 01:01:01\"")
                .d("ALL_CONTRIBUTORS_COUNT", "313")
                .d("ALL_FORKS_COUNT", "803")
                .d("ALL_SIZE_COUNT", "-225337685")
                .d("ALL_STARS_COUNT", "NULL")
                .d("MEMBERS_COUNT", "155")
                .d("ORGANIZATION_NAME", "NULL")
                .d("PRIVATE_PROJECT_COUNT", "NULL")
                .d("PROGRAM_LANGUAGES_COUNT", "392")
                .d("PUBLIC_PROJECT_COUNT", "NULL")
                .d("TAGS_COUNT", "NULL")
                .d("TEAMS_COUNT", "107")
                .d("EXTERNAL_CONTRIBUTORS_COUNT", "374")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_9_XYZ_")
                .get(baseUrlOfSut + "/statistics/languages?" + 
                    "organizations=5RgAuI&" + 
                    "EMextraParam123=3qeMxk")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_4() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/projects?" + 
                    "organizations=&" + 
                    "start_date=2058-03-18T22%3A17%3A53&" + 
                    "end_date=2001-09-17T13%3A16%3A43")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_5() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .header("x-organizations", "OxCc_aIMagG1g")
                .get(baseUrlOfSut + "/projects?" + 
                    "organizations=&" + 
                    "limit=332&" + 
                    "offset=751&" + 
                    "sortBy=UIKt9UYQySwkBS&" + 
                    "language=sqH7vk4SZVA7f")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_6() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/statistics/languages?offset=W1_vMdTpjY7HWC")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_7() throws Exception {
        
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
    
    
    @Test(timeout = 60000)
    public void test_8() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("STATISTICS", 99L)
                .d("ID", "325")
                .d("SNAPSHOT_DATE", "\"1996-08-30 20:29:02\"")
                .d("ALL_CONTRIBUTORS_COUNT", "NULL")
                .d("ALL_FORKS_COUNT", "386")
                .d("ALL_SIZE_COUNT", "37")
                .d("ALL_STARS_COUNT", "680")
                .d("MEMBERS_COUNT", "NULL")
                .d("ORGANIZATION_NAME", "\"Xta3VgcubQKuc\"")
                .d("PRIVATE_PROJECT_COUNT", "NULL")
                .d("PROGRAM_LANGUAGES_COUNT", "NULL")
                .d("PUBLIC_PROJECT_COUNT", "NULL")
                .d("TAGS_COUNT", "381")
                .d("TEAMS_COUNT", "638")
                .d("EXTERNAL_CONTRIBUTORS_COUNT", "359")
            .and().insertInto("PROJECT", 101L)
                .d("GIT_HUB_PROJECT_ID", "957")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/statistics?organizations=Xta3VgcubQKuc")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(1))
                .body("[0].'key'.'snapshotDate'", containsString("1996-08-30T20:29:02"))
                .body("[0].'privateProjectCount'", nullValue())
                .body("[0].'publicProjectCount'", nullValue())
                .body("[0].'membersCount'", nullValue())
                .body("[0].'teamsCount'", numberMatches(638.0))
                .body("[0].'allContributorsCount'", nullValue())
                .body("[0].'externalContributorsCount'", numberMatches(359.0))
                .body("[0].'allStarsCount'", numberMatches(680.0))
                .body("[0].'allForksCount'", numberMatches(386.0))
                .body("[0].'allSizeCount'", numberMatches(37.0))
                .body("[0].'programLanguagesCount'", nullValue())
                .body("[0].'tagsCount'", numberMatches(381.0))
                .body("[0].'organizationName'", containsString("Xta3VgcubQKuc"))
                .body("[0].'snapshotDate'", numberMatches(8.41429742E11));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_9() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("PROJECT", 26L)
                .d("COMMITS_COUNT", "NULL")
                .d("CONTRIBUTORS_COUNT", "706")
                .d("DESCRIPTION", "\"_EM_876_XYZ_\"")
                .d("FORKS_COUNT", "804")
                .d("GIT_HUB_PROJECT_ID", "871")
                .d("LAST_PUSHED", "NULL")
                .d("NAME", "NULL")
                .d("ORGANIZATION_NAME", "NULL")
                .d("PRIMARY_LANGUAGE", "NULL")
                .d("SCORE", "841")
                .d("SNAPSHOT_DATE", "\"1929-03-22 01:28:03\"")
                .d("STARS_COUNT", "NULL")
                .d("URL", "\"_EM_878_XYZ_\"")
                .d("TITLE", "NULL")
                .d("IMAGE", "NULL")
                .d("EXTERNAL_CONTRIBUTORS_COUNT", "272")
            .and().insertInto("CONTRIBUTOR", 27L)
                .d("ID", "348")
                .d("ORGANIZATION_ID", "337")
                .d("SNAPSHOT_DATE", "\"2023-12-27 12:30:45\"")
                .d("NAME", "\"_EM_881_XYZ_\"")
                .d("ORGANIZATION_NAME", "NULL")
                .d("ORGANIZATIONAL_COMMITS_COUNT", "193798207")
                .d("ORGANIZATIONAL_PROJECTS_COUNT", "944")
                .d("PERSONAL_COMMITS_COUNT", "79")
                .d("PERSONAL_PROJECTS_COUNT", "602")
                .d("URL", "\"_EM_882_XYZ_\"")
            .and().insertInto("STATISTICS", 28L)
                .d("ID", "2")
                .d("SNAPSHOT_DATE", "\"2057-03-31 02:48:14\"")
                .d("ALL_CONTRIBUTORS_COUNT", "NULL")
                .d("ALL_FORKS_COUNT", "106")
                .d("ALL_SIZE_COUNT", "NULL")
                .d("ALL_STARS_COUNT", "591")
                .d("MEMBERS_COUNT", "413469067")
                .d("ORGANIZATION_NAME", "\"QxFW4m\"")
                .d("PRIVATE_PROJECT_COUNT", "NULL")
                .d("PROGRAM_LANGUAGES_COUNT", "NULL")
                .d("PUBLIC_PROJECT_COUNT", "NULL")
                .d("TAGS_COUNT", "NULL")
                .d("TEAMS_COUNT", "NULL")
                .d("EXTERNAL_CONTRIBUTORS_COUNT", "263")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        
        given().accept("application/json;charset=utf-8")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/export")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'contributors'.size()", equalTo(1))
                .body("'contributors'[0].'key'.'organizationId'", numberMatches(337.0))
                .body("'contributors'[0].'key'.'snapshotDate'", containsString("2023-12-27T12:30:45"))
                .body("'contributors'[0].'loginId'", containsString(""))
                .body("'contributors'[0].'name'", containsString("_EM_881_XYZ_"))
                .body("'contributors'[0].'url'", containsString("_EM_882_XYZ_"))
                .body("'contributors'[0].'organizationalCommitsCount'", numberMatches(1.93798207E8))
                .body("'contributors'[0].'personalCommitsCount'", numberMatches(79.0))
                .body("'contributors'[0].'personalProjectsCount'", numberMatches(602.0))
                .body("'contributors'[0].'organizationalProjectsCount'", numberMatches(944.0))
                .body("'contributors'[0].'organizationName'", nullValue())
                .body("'contributors'[0].'organizationId'", numberMatches(337.0))
                .body("'contributors'[0].'snapshotDate'", numberMatches(1.703676645E12))
                .body("'projects'.size()", equalTo(1))
                .body("'projects'[0].'languageList'.size()", equalTo(0))
                .body("'projects'[0].'gitHubProjectId'", numberMatches(871.0))
                .body("'projects'[0].'snapshotDate'", containsString("1929-03-22T01:28:03"))
                .body("'projects'[0].'name'", nullValue())
                .body("'projects'[0].'title'", nullValue())
                .body("'projects'[0].'image'", nullValue())
                .body("'projects'[0].'organizationName'", nullValue())
                .body("'projects'[0].'url'", containsString("_EM_878_XYZ_"))
                .body("'projects'[0].'description'", containsString("_EM_876_XYZ_"))
                .body("'projects'[0].'starsCount'", nullValue())
                .body("'projects'[0].'commitsCount'", nullValue())
                .body("'projects'[0].'forksCount'", numberMatches(804.0))
                .body("'projects'[0].'contributorsCount'", numberMatches(706.0))
                .body("'projects'[0].'externalContributorsCount'", numberMatches(272.0))
                .body("'projects'[0].'score'", numberMatches(841.0))
                .body("'projects'[0].'lastPushed'", nullValue())
                .body("'projects'[0].'primaryLanguage'", nullValue())
                .body("'projects'[0].'maintainers'.size()", equalTo(0))
                .body("'statistics'.size()", equalTo(1))
                .body("'statistics'[0].'key'.'snapshotDate'", containsString("2057-03-31T02:48:14"))
                .body("'statistics'[0].'privateProjectCount'", nullValue())
                .body("'statistics'[0].'publicProjectCount'", nullValue())
                .body("'statistics'[0].'membersCount'", numberMatches(4.13469067E8))
                .body("'statistics'[0].'teamsCount'", nullValue())
                .body("'statistics'[0].'allContributorsCount'", nullValue())
                .body("'statistics'[0].'externalContributorsCount'", numberMatches(263.0))
                .body("'statistics'[0].'allStarsCount'", numberMatches(591.0))
                .body("'statistics'[0].'allForksCount'", numberMatches(106.0))
                .body("'statistics'[0].'allSizeCount'", nullValue())
                .body("'statistics'[0].'programLanguagesCount'", nullValue())
                .body("'statistics'[0].'tagsCount'", nullValue())
                .body("'statistics'[0].'organizationName'", containsString("QxFW4m"))
                .body("'statistics'[0].'snapshotDate'", numberMatches(2.753225294E12));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_10() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("CONTRIBUTOR", 128L)
                .d("ID", "655")
                .d("ORGANIZATION_ID", "252")
                .d("SNAPSHOT_DATE", "\"1953-06-25 05:38:40\"")
                .d("NAME", "\"NpOIfz9S\"")
                .d("ORGANIZATION_NAME", "NULL")
                .d("ORGANIZATIONAL_COMMITS_COUNT", "15")
                .d("ORGANIZATIONAL_PROJECTS_COUNT", "NULL")
                .d("PERSONAL_COMMITS_COUNT", "822")
                .d("PERSONAL_PROJECTS_COUNT", "194")
                .d("URL", "\"UtQQTUvNE\"")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .header("x-organizations", "252")
                .get(baseUrlOfSut + "/contributors?" + 
                    "organizations=252&" + 
                    "q=_EM_2462_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(0));
        
    }


}
