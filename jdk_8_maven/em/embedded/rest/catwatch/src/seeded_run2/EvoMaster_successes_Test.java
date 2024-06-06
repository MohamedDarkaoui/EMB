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
 * This file was automatically generated by EvoMaster on 2024-06-02T11:37:05.132+02:00[Europe/Paris]
 * <br>
 * The generated test suite contains 11 tests
 * <br>
 * Covered targets: 475
 * <br>
 * Used time: 1h 2m 36s
 * <br>
 * Needed budget for current results: 94%
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
        controller.resetDatabase(Arrays.asList("STATISTICS","CONTRIBUTOR","PROJECT","LANGUAGE_LIST","MAINTAINERS"));
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
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/statistics/languages?organizations=rzamf1BMQgN")
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
                    "offset=352&" + 
                    "q=_EM%5D696_XYZa&" + 
                    "language=_EM_697_XYZ_")
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
                .header("x-organizations", "OO3AWQK")
                .header("X-Organizations", "9M6")
                .get(baseUrlOfSut + "/projects?" + 
                    "organizations=&" + 
                    "limit=944&" + 
                    "sortBy=SLZDe7i6ZS&" + 
                    "q=rz309WPoN")
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
                .get(baseUrlOfSut + "/statistics?" + 
                    "organizations=organizUtiUl1&" + 
                    "start_date=2034-05-29T04%3A04%3A12Z&" + 
                    "end_date=2024-05-31T04%3A04%3A12Z")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_7() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("STATISTICS", 33L)
                .d("ID", "639")
                .d("SNAPSHOT_DATE", "\"1979-10-08 04:29:15\"")
                .d("ALL_CONTRIBUTORS_COUNT", "NULL")
                .d("ALL_FORKS_COUNT", "NULL")
                .d("ALL_SIZE_COUNT", "443")
                .d("ALL_STARS_COUNT", "NULL")
                .d("MEMBERS_COUNT", "NULL")
                .d("ORGANIZATION_NAME", "\"Ei1rVYVILhh\"")
                .d("PRIVATE_PROJECT_COUNT", "565")
                .d("PROGRAM_LANGUAGES_COUNT", "996")
                .d("PUBLIC_PROJECT_COUNT", "81")
                .d("TAGS_COUNT", "948")
                .d("TEAMS_COUNT", "NULL")
                .d("EXTERNAL_CONTRIBUTORS_COUNT", "NULL")
            .and().insertInto("CONTRIBUTOR", 34L)
                .d("ID", "607")
                .d("ORGANIZATION_ID", "982")
                .d("SNAPSHOT_DATE", "\"1940-12-30 16:40:54\"")
                .d("NAME", "\"0QL0SXNXJ\"")
                .d("ORGANIZATION_NAME", "\"_EM_962_XYZ_\"")
                .d("ORGANIZATIONAL_COMMITS_COUNT", "NULL")
                .d("ORGANIZATIONAL_PROJECTS_COUNT", "NULL")
                .d("PERSONAL_COMMITS_COUNT", "NULL")
                .d("PERSONAL_PROJECTS_COUNT", "959")
                .d("URL", "NULL")
            .and().insertInto("PROJECT", 35L)
                .d("COMMITS_COUNT", "390")
                .d("CONTRIBUTORS_COUNT", "NULL")
                .d("DESCRIPTION", "\"_EM_964_XYZ_\"")
                .d("FORKS_COUNT", "-2036744492")
                .d("GIT_HUB_PROJECT_ID", "444")
                .d("LAST_PUSHED", "NULL")
                .d("NAME", "NULL")
                .d("ORGANIZATION_NAME", "NULL")
                .d("PRIMARY_LANGUAGE", "\"9f7pXwr9S\"")
                .d("SCORE", "293")
                .d("SNAPSHOT_DATE", "NULL")
                .d("STARS_COUNT", "490")
                .d("URL", "NULL")
                .d("TITLE", "NULL")
                .d("IMAGE", "\"_EM_968_XYZ_\"")
                .d("EXTERNAL_CONTRIBUTORS_COUNT", "NULL")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/statistics/languages")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_8() throws Exception {
        
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
    public void test_9() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("CONTRIBUTOR", 41L)
                .d("ID", "526")
                .d("ORGANIZATION_ID", "919")
                .d("SNAPSHOT_DATE", "\"2074-06-20 22:01:38\"")
                .d("NAME", "NULL")
                .d("ORGANIZATION_NAME", "\"_EM_1036_XYZ_\"")
                .d("ORGANIZATIONAL_COMMITS_COUNT", "30")
                .d("ORGANIZATIONAL_PROJECTS_COUNT", "NULL")
                .d("PERSONAL_COMMITS_COUNT", "734")
                .d("PERSONAL_PROJECTS_COUNT", "-1031003885")
                .d("URL", "NULL")
            .and().insertInto("PROJECT", 42L)
                .d("COMMITS_COUNT", "NULL")
                .d("CONTRIBUTORS_COUNT", "NULL")
                .d("DESCRIPTION", "\"Us\"")
                .d("FORKS_COUNT", "NULL")
                .d("GIT_HUB_PROJECT_ID", "-7330083136983397033")
                .d("LAST_PUSHED", "\"_EM_1038_XYZ_\"")
                .d("NAME", "NULL")
                .d("ORGANIZATION_NAME", "\"919\"")
                .d("PRIMARY_LANGUAGE", "\"iX7bZ5\"")
                .d("SCORE", "NULL")
                .d("SNAPSHOT_DATE", "NULL")
                .d("STARS_COUNT", "648")
                .d("URL", "\"_EM_1040_XYZ_\"")
                .d("TITLE", "NULL")
                .d("IMAGE", "NULL")
                .d("EXTERNAL_CONTRIBUTORS_COUNT", "576")
            .and().insertInto("STATISTICS", 43L)
                .d("ID", "22")
                .d("SNAPSHOT_DATE", "\"1944-03-06 14:48:49\"")
                .d("ALL_CONTRIBUTORS_COUNT", "643")
                .d("ALL_FORKS_COUNT", "NULL")
                .d("ALL_SIZE_COUNT", "113")
                .d("ALL_STARS_COUNT", "930")
                .d("MEMBERS_COUNT", "NULL")
                .d("ORGANIZATION_NAME", "\"919\"")
                .d("PRIVATE_PROJECT_COUNT", "NULL")
                .d("PROGRAM_LANGUAGES_COUNT", "NULL")
                .d("PUBLIC_PROJECT_COUNT", "754")
                .d("TAGS_COUNT", "363")
                .d("TEAMS_COUNT", "NULL")
                .d("EXTERNAL_CONTRIBUTORS_COUNT", "247")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/statistics?organizations=919")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(1))
                .body("[0].'key'.'snapshotDate'", containsString("1944-03-06T14:48:49"))
                .body("[0].'privateProjectCount'", nullValue())
                .body("[0].'publicProjectCount'", numberMatches(754.0))
                .body("[0].'membersCount'", nullValue())
                .body("[0].'teamsCount'", nullValue())
                .body("[0].'allContributorsCount'", numberMatches(643.0))
                .body("[0].'externalContributorsCount'", numberMatches(247.0))
                .body("[0].'allStarsCount'", numberMatches(930.0))
                .body("[0].'allForksCount'", nullValue())
                .body("[0].'allSizeCount'", numberMatches(113.0))
                .body("[0].'programLanguagesCount'", nullValue())
                .body("[0].'tagsCount'", numberMatches(363.0))
                .body("[0].'organizationName'", containsString("919"))
                .body("[0].'snapshotDate'", numberMatches(-8.14875071E11));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_10() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("STATISTICS", 33L)
                .d("ID", "639")
                .d("SNAPSHOT_DATE", "\"1979-10-08 04:29:15\"")
                .d("ALL_CONTRIBUTORS_COUNT", "NULL")
                .d("ALL_FORKS_COUNT", "NULL")
                .d("ALL_SIZE_COUNT", "443")
                .d("ALL_STARS_COUNT", "NULL")
                .d("MEMBERS_COUNT", "NULL")
                .d("ORGANIZATION_NAME", "\"Ei1rVYVILhh\"")
                .d("PRIVATE_PROJECT_COUNT", "565")
                .d("PROGRAM_LANGUAGES_COUNT", "996")
                .d("PUBLIC_PROJECT_COUNT", "81")
                .d("TAGS_COUNT", "948")
                .d("TEAMS_COUNT", "NULL")
                .d("EXTERNAL_CONTRIBUTORS_COUNT", "NULL")
            .and().insertInto("CONTRIBUTOR", 34L)
                .d("ID", "607")
                .d("ORGANIZATION_ID", "982")
                .d("SNAPSHOT_DATE", "\"1940-12-30 16:40:54\"")
                .d("NAME", "\"0QL0SXNXJ\"")
                .d("ORGANIZATION_NAME", "\"_EM_962_XYZ_\"")
                .d("ORGANIZATIONAL_COMMITS_COUNT", "NULL")
                .d("ORGANIZATIONAL_PROJECTS_COUNT", "NULL")
                .d("PERSONAL_COMMITS_COUNT", "NULL")
                .d("PERSONAL_PROJECTS_COUNT", "959")
                .d("URL", "NULL")
            .and().insertInto("PROJECT", 35L)
                .d("COMMITS_COUNT", "390")
                .d("CONTRIBUTORS_COUNT", "NULL")
                .d("DESCRIPTION", "\"_EM_964_XYZ_\"")
                .d("FORKS_COUNT", "-2036744492")
                .d("GIT_HUB_PROJECT_ID", "444")
                .d("LAST_PUSHED", "NULL")
                .d("NAME", "NULL")
                .d("ORGANIZATION_NAME", "NULL")
                .d("PRIMARY_LANGUAGE", "\"9f7pXwr9S\"")
                .d("SCORE", "293")
                .d("SNAPSHOT_DATE", "NULL")
                .d("STARS_COUNT", "490")
                .d("URL", "NULL")
                .d("TITLE", "NULL")
                .d("IMAGE", "\"_EM_968_XYZ_\"")
                .d("EXTERNAL_CONTRIBUTORS_COUNT", "NULL")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        
        given().accept("application/json;charset=utf-8")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/export?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'contributors'.size()", equalTo(1))
                .body("'contributors'[0].'key'.'organizationId'", numberMatches(982.0))
                .body("'contributors'[0].'key'.'snapshotDate'", containsString("1940-12-30T16:40:54"))
                .body("'contributors'[0].'loginId'", containsString(""))
                .body("'contributors'[0].'name'", containsString("0QL0SXNXJ"))
                .body("'contributors'[0].'url'", nullValue())
                .body("'contributors'[0].'organizationalCommitsCount'", nullValue())
                .body("'contributors'[0].'personalCommitsCount'", nullValue())
                .body("'contributors'[0].'personalProjectsCount'", numberMatches(959.0))
                .body("'contributors'[0].'organizationalProjectsCount'", nullValue())
                .body("'contributors'[0].'organizationName'", containsString("_EM_962_XYZ_"))
                .body("'contributors'[0].'organizationId'", numberMatches(982.0))
                .body("'contributors'[0].'snapshotDate'", numberMatches(-9.15268746E11))
                .body("'projects'.size()", equalTo(1))
                .body("'projects'[0].'languageList'.size()", equalTo(0))
                .body("'projects'[0].'gitHubProjectId'", numberMatches(444.0))
                .body("'projects'[0].'snapshotDate'", nullValue())
                .body("'projects'[0].'name'", nullValue())
                .body("'projects'[0].'title'", nullValue())
                .body("'projects'[0].'image'", containsString("_EM_968_XYZ_"))
                .body("'projects'[0].'organizationName'", nullValue())
                .body("'projects'[0].'url'", nullValue())
                .body("'projects'[0].'description'", containsString("_EM_964_XYZ_"))
                .body("'projects'[0].'starsCount'", numberMatches(490.0))
                .body("'projects'[0].'commitsCount'", numberMatches(390.0))
                .body("'projects'[0].'forksCount'", numberMatches(-2.036744492E9))
                .body("'projects'[0].'contributorsCount'", nullValue())
                .body("'projects'[0].'externalContributorsCount'", nullValue())
                .body("'projects'[0].'score'", numberMatches(293.0))
                .body("'projects'[0].'lastPushed'", nullValue())
                .body("'projects'[0].'primaryLanguage'", containsString("9f7pXwr9S"))
                .body("'projects'[0].'maintainers'.size()", equalTo(0))
                .body("'statistics'.size()", equalTo(1))
                .body("'statistics'[0].'key'.'snapshotDate'", containsString("1979-10-08T04:29:15"))
                .body("'statistics'[0].'privateProjectCount'", numberMatches(565.0))
                .body("'statistics'[0].'publicProjectCount'", numberMatches(81.0))
                .body("'statistics'[0].'membersCount'", nullValue())
                .body("'statistics'[0].'teamsCount'", nullValue())
                .body("'statistics'[0].'allContributorsCount'", nullValue())
                .body("'statistics'[0].'externalContributorsCount'", nullValue())
                .body("'statistics'[0].'allStarsCount'", nullValue())
                .body("'statistics'[0].'allForksCount'", nullValue())
                .body("'statistics'[0].'allSizeCount'", numberMatches(443.0))
                .body("'statistics'[0].'programLanguagesCount'", numberMatches(996.0))
                .body("'statistics'[0].'tagsCount'", numberMatches(948.0))
                .body("'statistics'[0].'organizationName'", containsString("Ei1rVYVILhh"))
                .body("'statistics'[0].'snapshotDate'", numberMatches(3.08201355E11));
        
    }


}
