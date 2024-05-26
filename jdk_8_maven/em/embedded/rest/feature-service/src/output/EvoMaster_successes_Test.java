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
 * This file was automatically generated by EvoMaster on 2024-05-26T00:22:42.033+02:00[Europe/Paris]
 * <br>
 * The generated test suite contains 17 tests
 * <br>
 * Covered targets: 504
 * <br>
 * Used time: 0h 5m 3s
 * <br>
 * Needed budget for current results: 67%
 * <br>
 * This file contains test cases that represent successful calls.
 */
public class EvoMaster_successes_Test {

    
    private static final SutHandler controller = new em.embedded.org.javiermf.features.EmbeddedEvoMasterController();
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
        controller.resetDatabase(Arrays.asList("PRODUCT","CONSTRAINT_EXCLUDES","CONSTRAINT_REQUIRES","FEATURE","PRODUCT_CONFIGURATION_ACTIVED_FEATURES","PRODUCT_CONFIGURATION","HT_feature_constraint"));
        controller.resetStateOfSUT();
    }
    
    
    
    
    @Test(timeout = 60000)
    public void test_0() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .get(baseUrlOfSut + "/swagger.json")
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
        List<InsertionDto> insertions = sql().insertInto("PRODUCT", 283L)
                .d("NAME", "\"O0g\"")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/products/O0g/features")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_2() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_32_XYZ_")
                .get(baseUrlOfSut + "/products?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(1))
                .body("", hasItems("ELEARNING_SITE"));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_3() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/products/ELEARNING_SITE?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'name'", containsString("ELEARNING_SITE"))
                .body("'features'.size()", equalTo(9))
                .body("'features'[0].'name'", containsString("IN_TRIAL_PERIOD"))
                .body("'features'[0].'description'", nullValue())
                .body("'features'[1].'name'", containsString("COURSE_SELLING"))
                .body("'features'[1].'description'", nullValue())
                .body("'features'[2].'name'", containsString("CREDIT_CARD_PAYMENT"))
                .body("'features'[2].'description'", nullValue())
                // Skipping assertions on the remaining 6 elements. This limit of 3 elements can be increased in the configurations
                .body("'constraints'.size()", equalTo(3))
                .body("'constraints'[0].'sourceFeatureName'", containsString("CREDIT_CARD"))
                .body("'constraints'[0].'requiredFeatureName'", containsString("COURSE_SELLING"))
                .body("'constraints'[0].'type'", containsString("requires"))
                .body("'constraints'[1].'sourceFeatureName'", containsString("IN_TRIAL_PERIOD"))
                .body("'constraints'[1].'excludedFeatureName'", containsString("COURSE_SELLING"))
                .body("'constraints'[1].'type'", containsString("excludes"))
                .body("'constraints'[2].'sourceFeatureName'", containsString("PAYPAL_PAYMENT"))
                .body("'constraints'[2].'requiredFeatureName'", containsString("COURSE_SELLING"))
                .body("'constraints'[2].'type'", containsString("requires"));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_4() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_271_XYZ_")
                .get(baseUrlOfSut + "/products/ELEARNING_SITE/configurations/UNIVERSITY_X?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'name'", containsString("UNIVERSITY_X"))
                .body("'valid'", equalTo(true))
                .body("'activedFeatures'.size()", equalTo(4))
                .body("'activedFeatures'[0].'name'", containsString("VIDEO_LESSONS"))
                .body("'activedFeatures'[0].'description'", nullValue())
                .body("'activedFeatures'[1].'name'", containsString("ONLINE_FORUM"))
                .body("'activedFeatures'[1].'description'", nullValue())
                .body("'activedFeatures'[2].'name'", containsString("CHAT"))
                .body("'activedFeatures'[2].'description'", nullValue())
                ; // Skipping assertions on the remaining 1 elements. This limit of 3 elements can be increased in the configurations
        
    }
    
    
    @Test(timeout = 60000)
    public void test_5() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_666_XYZ_")
                .get(baseUrlOfSut + "/products/ELEARNING_SITE/configurations?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(1))
                .body("", hasItems("UNIVERSITY_X"));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_6() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/products/ELEARNING_SITE/configurations/UNIVERSITY_X/features?EMextraParam123=_EM_170_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(4))
                .body("", hasItems("ONLINE_FORUM", "CHAT", "VIDEO_LESSONS", "IN_TRIAL_PERIOD"));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_7() throws Exception {
        
        String location_productName = "";
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .post(baseUrlOfSut + "/products/x")
                .then()
                .statusCode(201)
                .assertThat()
                .body(isEmptyOrNullString());
        location_productName = res_0.extract().header("location");
        assertTrue(isValidURIorEmpty(location_productName));
        
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/x-www-form-urlencoded")
                .body("description=_EM_82_XYZ_")
                .post(resolveLocation(location_productName, baseUrlOfSut + "/products/x/features/NeVd?EMextraParam123=42"))
                .then()
                .statusCode(201)
                .assertThat()
                .body(isEmptyOrNullString());
        
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "42")
                .contentType("application/x-www-form-urlencoded")
                .body("")
                .put(resolveLocation(location_productName, baseUrlOfSut + "/products/x/features/NeVd?EMextraParam123=42"))
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'name'", containsString("NeVd"))
                .body("'description'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_8() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .post(baseUrlOfSut + "/products/_EM_54_XYZ_")
                .then()
                .statusCode(201)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_9() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("PRODUCT", 4078L)
                .d("NAME", "\"B\"")
            .and().insertInto("FEATURE", 4077L)
                .d("DESCRIPTION", "\"nIO1DaTCg\"")
                .d("NAME", "\"_EM_3199_XYZ_\"")
                .d("PRODUCT_ID", "1")
            .and().insertInto("PRODUCT", 4080L)
                .d("NAME", "\"gfCtKgnyvvh\"")
            .and().insertInto("FEATURE", 4079L)
                .d("DESCRIPTION", "\"_EM_2930_XYZ_\"")
                .d("NAME", "\"jghxuX0Vk4R_T\"")
                .r("PRODUCT_ID", 4078L)
            .and().insertInto("PRODUCT", 4082L)
                .d("NAME", "\"ZuR\"")
            .and().insertInto("FEATURE", 4081L)
                .d("DESCRIPTION", "\"IFPfEg_q6MI75v\"")
                .d("NAME", "\"_EM_3200_XYZ_\"")
                .d("PRODUCT_ID", "NULL")
            .and().insertInto("PRODUCT", 4084L)
                .d("NAME", "\"19\"")
            .and().insertInto("FEATURE", 4083L)
                .d("DESCRIPTION", "\"\"")
                .d("NAME", "\"b5ecq8R0\"")
                .d("PRODUCT_ID", "1")
            .and().insertInto("PRODUCT", 4086L)
                .d("NAME", "\"OSAuYiR2CA9dg\"")
            .and().insertInto("FEATURE", 4085L)
                .d("DESCRIPTION", "\"Ia5\"")
                .d("NAME", "\"KScLPE7e7qEEJJwh\"")
                .r("PRODUCT_ID", 4078L)
            .and().insertInto("PRODUCT", 4091L)
                .d("NAME", "\"U5zyEo0cgVdLUUt\"")
            .and().insertInto("PRODUCT_CONFIGURATION", 4090L)
                .d("NAME", "\"_EM_3032_XYZ_\"")
            .and().insertInto("PRODUCT", 4089L)
                .d("NAME", "\"n7R\"")
            .and().insertInto("FEATURE", 4088L)
                .d("NAME", "\"cJy\"")
            .and().insertInto("PRODUCT_CONFIGURATION_ACTIVED_FEATURES", 4087L)
                .r("IN_CONFIGURATIONS_ID", 4090L)
                .d("ACTIVED_FEATURES_ID", "3")
            .and().insertInto("PRODUCT", 4096L)
                .d("NAME", "\"_EM_3201_XYZ_\"")
            .and().insertInto("PRODUCT_CONFIGURATION", 4095L)
                .d("NAME", "\"ZuR\"")
            .and().insertInto("PRODUCT", 4094L)
                .d("NAME", "\"OnPjY\"")
            .and().insertInto("FEATURE", 4093L)
                .d("NAME", "\"1517133\"")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .post(baseUrlOfSut + "/products/ELEARNING_SITE/configurations/UNIVERSITY_X")
                .then()
                .statusCode(201)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_10() throws Exception {
        
        String location_productName = "";
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .post(baseUrlOfSut + "/products/DK")
                .then()
                .statusCode(201)
                .assertThat()
                .body(isEmptyOrNullString());
        location_productName = res_0.extract().header("location");
        assertTrue(isValidURIorEmpty(location_productName));
        
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/x-www-form-urlencoded")
                .body("")
                .post(resolveLocation(location_productName, baseUrlOfSut + "/products/DK/constraints/requires"))
                .then()
                .statusCode(201)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_11() throws Exception {
        
        String location_productName = "";
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .post(baseUrlOfSut + "/products/Kakq8I?EMextraParam123=42")
                .then()
                .statusCode(201)
                .assertThat()
                .body(isEmptyOrNullString());
        location_productName = res_0.extract().header("location");
        assertTrue(isValidURIorEmpty(location_productName));
        
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/x-www-form-urlencoded")
                .body("")
                .post(resolveLocation(location_productName, baseUrlOfSut + "/products/Kakq8I/constraints/excludes"))
                .then()
                .statusCode(201)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_12() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("PRODUCT", 4078L)
                .d("NAME", "\"B\"")
            .and().insertInto("FEATURE", 4077L)
                .d("DESCRIPTION", "\"nIO1DaTCg\"")
                .d("NAME", "\"_EM_3199_XYZ_\"")
                .d("PRODUCT_ID", "1")
            .and().insertInto("PRODUCT", 4080L)
                .d("NAME", "\"gfCtKgnyvvh\"")
            .and().insertInto("FEATURE", 4079L)
                .d("DESCRIPTION", "\"_EM_2930_XYZ_\"")
                .d("NAME", "\"jghxuX0Vk4R_T\"")
                .r("PRODUCT_ID", 4078L)
            .and().insertInto("PRODUCT", 4082L)
                .d("NAME", "\"ZuR\"")
            .and().insertInto("FEATURE", 4081L)
                .d("DESCRIPTION", "\"IFPfEg_q6MI75v\"")
                .d("NAME", "\"_EM_3200_XYZ_\"")
                .d("PRODUCT_ID", "NULL")
            .and().insertInto("PRODUCT", 4084L)
                .d("NAME", "\"19\"")
            .and().insertInto("FEATURE", 4083L)
                .d("DESCRIPTION", "\"\"")
                .d("NAME", "\"b5ecq8R0\"")
                .d("PRODUCT_ID", "1")
            .and().insertInto("PRODUCT", 4086L)
                .d("NAME", "\"OSAuYiR2CA9dg\"")
            .and().insertInto("FEATURE", 4085L)
                .d("DESCRIPTION", "\"Ia5\"")
                .d("NAME", "\"KScLPE7e7qEEJJwh\"")
                .r("PRODUCT_ID", 4078L)
            .and().insertInto("PRODUCT", 4091L)
                .d("NAME", "\"U5zyEo0cgVdLUUt\"")
            .and().insertInto("PRODUCT_CONFIGURATION", 4090L)
                .d("NAME", "\"_EM_3032_XYZ_\"")
            .and().insertInto("PRODUCT", 4089L)
                .d("NAME", "\"n7R\"")
            .and().insertInto("FEATURE", 4088L)
                .d("NAME", "\"cJy\"")
            .and().insertInto("PRODUCT_CONFIGURATION_ACTIVED_FEATURES", 4087L)
                .r("IN_CONFIGURATIONS_ID", 4090L)
                .d("ACTIVED_FEATURES_ID", "3")
            .and().insertInto("PRODUCT", 4096L)
                .d("NAME", "\"_EM_3201_XYZ_\"")
            .and().insertInto("PRODUCT_CONFIGURATION", 4095L)
                .d("NAME", "\"ZuR\"")
            .and().insertInto("PRODUCT", 4094L)
                .d("NAME", "\"OnPjY\"")
            .and().insertInto("FEATURE", 4093L)
                .d("NAME", "\"1517133\"")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/x-www-form-urlencoded")
                .body("description=pW1vQezZbpX")
                .post(baseUrlOfSut + "/products/ELEARNING_SITE/features/MSN")
                .then()
                .statusCode(201)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_13() throws Exception {
        
        String location_productName = "";
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .post(baseUrlOfSut + "/products/Sq_7l7OKTiJ1?EMextraParam123=42")
                .then()
                .statusCode(201)
                .assertThat()
                .body(isEmptyOrNullString());
        location_productName = res_0.extract().header("location");
        assertTrue(isValidURIorEmpty(location_productName));
        
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/x-www-form-urlencoded")
                .body("")
                .post(resolveLocation(location_productName, baseUrlOfSut + "/products/Sq_7l7OKTiJ1/features/KusSby"))
                .then()
                .statusCode(201)
                .assertThat()
                .body(isEmptyOrNullString());
        
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .delete(resolveLocation(location_productName, baseUrlOfSut + "/products/Sq_7l7OKTiJ1/features/KusSby?EMextraParam123=42"))
                .then()
                .statusCode(204)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_14() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .delete(baseUrlOfSut + "/products/_EM_7_XYZ_/constraints/-1424227091?EMextraParam123=_EM_8_XYZ_")
                .then()
                .statusCode(204)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_15() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_13_XYZ_")
                .get(baseUrlOfSut + "/products/_EM_10_XYZ_/configurations/_EM_11_XYZ_")
                .then()
                .statusCode(204)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_16() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("PRODUCT", 8281L)
                .d("NAME", "\"K4dkoq\"")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .delete(baseUrlOfSut + "/products/K4dkoq")
                .then()
                .statusCode(204)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }


}
