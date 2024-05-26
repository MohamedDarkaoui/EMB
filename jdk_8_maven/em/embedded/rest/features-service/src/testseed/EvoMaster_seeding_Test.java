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
 * This file was automatically generated by EvoMaster on 2024-05-26T00:14:23.929+02:00[Europe/Paris]
 * <br>
 * The generated test suite contains 17 tests
 * <br>
 * Covered targets: 203
 * <br>
 * Used time: 0h 5m 3s
 * <br>
 * Needed budget for current results: 95%
 * <br>
 * This file contains test cases generated during seeding.
 */
public class EvoMaster_seeding_Test {

    
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
        controller.resetDatabase(Arrays.asList("HT_feature_constraint","constraint_excludes","constraint_requires","product","FEATURE","PRODUCT_CONFIGURATION_ACTIVED_FEATURES","PRODUCT_CONFIGURATION"));
        controller.resetStateOfSUT();
    }
    
    
    
    
    @Test(timeout = 60000)
    public void test_0_with500() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/x-www-form-urlencoded")
                .body("")
                .post(baseUrlOfSut + "/products/Product_1/constraints/excludes?EMextraParam123=42")
                .then()
                .statusCode(500) // org/javiermf/features/daos/ProductsDAO_41_findByName
                .assertThat()
                .contentType("text/html");
        
    }
    
    
    @Test(timeout = 60000)
    public void test_1_with500() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/x-www-form-urlencoded")
                .body("")
                .post(baseUrlOfSut + "/products/Product_1/constraints/requires?EMextraParam123=42")
                .then()
                .statusCode(500) // org/javiermf/features/daos/ProductsDAO_41_findByName
                .assertThat()
                .contentType("text/html");
        
    }
    
    
    @Test(timeout = 60000)
    public void test_2_with500() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .delete(baseUrlOfSut + "/products/Product_1/features/Feature_1?EMextraParam123=42")
                .then()
                .statusCode(500) // org/javiermf/features/daos/ProductsDAO_41_findByName
                .assertThat()
                .contentType("text/html");
        
    }
    
    
    @Test(timeout = 60000)
    public void test_3_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/products/Product_1?EMextraParam123=42")
                .then()
                .statusCode(500) // org/javiermf/features/daos/ProductsDAO_41_findByName
                .assertThat()
                .contentType("text/html");
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_4_with500() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/x-www-form-urlencoded")
                .body("")
                .post(baseUrlOfSut + "/products/Product_1/features/Feature_1?EMextraParam123=42")
                .then()
                .statusCode(500) // org/javiermf/features/daos/ProductsDAO_41_findByName
                .assertThat()
                .contentType("text/html");
        
    }
    
    
    @Test(timeout = 60000)
    public void test_5_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/products/Product_1/features?EMextraParam123=42")
                .then()
                .statusCode(500) // org/javiermf/features/daos/ProductsDAO_41_findByName
                .assertThat()
                .contentType("text/html");
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_6_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/x-www-form-urlencoded")
                .body("")
                .put(baseUrlOfSut + "/products/Product_1/features/Feature_1?EMextraParam123=42")
                .then()
                .statusCode(500) // org/javiermf/features/daos/ProductsDAO_41_findByName
                .assertThat()
                .contentType("text/html");
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_7_with500() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .delete(baseUrlOfSut + "/products/Product_1/configurations/Product_1_Configuration_1/features/Feature_1?EMextraParam123=42")
                .then()
                .statusCode(500) // org/javiermf/features/services/ProductsConfigurationsService_70_removeFeatureFromConfiguration
                .assertThat()
                .contentType("text/html");
        
    }
    
    
    @Test(timeout = 60000)
    public void test_8_with500() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .post(baseUrlOfSut + "/products/Product_1/configurations/Product_1_Configuration_2/features/Feature_2?EMextraParam123=42")
                .then()
                .statusCode(500) // org/javiermf/features/services/ProductsConfigurationsService_79_addFeatureFromConfiguration
                .assertThat()
                .contentType("text/html");
        
    }
    
    
    @Test(timeout = 60000)
    public void test_9_with500() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .delete(baseUrlOfSut + "/products/Product_1/configurations/Product_1_Configuration_1?EMextraParam123=42")
                .then()
                .statusCode(500) // org/javiermf/features/daos/ProductsConfigurationsDAO_71_deleteConfigurationForProduct
                .assertThat()
                .contentType("text/html");
        
    }
    
    
    @Test(timeout = 60000)
    public void test_10_with500() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .post(baseUrlOfSut + "/products/Product_3?EMextraParam123=42")
                .then()
                .statusCode(500) // org/javiermf/features/daos/ProductsDAO_64_insert
                .assertThat()
                .contentType("text/html");
        
    }
    
    
    @Test(timeout = 60000)
    public void test_11_with500() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .delete(baseUrlOfSut + "/products/Product_1?EMextraParam123=42")
                .then()
                .statusCode(500) // org/javiermf/features/daos/ProductsDAO_41_findByName
                .assertThat()
                .contentType("text/html");
        
    }
    
    
    @Test(timeout = 60000)
    public void test_12_with500() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .post(baseUrlOfSut + "/products/Product_1/configurations/newConfig?EMextraParam123=42")
                .then()
                .statusCode(500) // org/javiermf/features/daos/ProductsDAO_41_findByName
                .assertThat()
                .contentType("text/html");
        
    }
    
    
    @Test(timeout = 60000)
    public void test_13() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/products/Product_1/configurations?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_14() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/products?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(1))
                .body("", hasItems("ELEARNING_SITE"));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_15() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .delete(baseUrlOfSut + "/products/Product_1/constraints/1?EMextraParam123=42")
                .then()
                .statusCode(204)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_16() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/products/Product_1/configurations/Product_1_Configuration_2?EMextraParam123=42")
                .then()
                .statusCode(204)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }


}
