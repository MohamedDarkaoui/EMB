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
 * This file was automatically generated by EvoMaster on 2024-05-31T22:28:16.260+02:00[Europe/Paris]
 * <br>
 * The generated test suite contains 38 tests
 * <br>
 * Covered targets: 688
 * <br>
 * Used time: 0h 10m 10s
 * <br>
 * Needed budget for current results: 70%
 * <br>
 * This file contains test cases that represent failed calls, but not indicative of faults.
 */
public class EvoMaster_others_Test {

    
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
        
        String location_hospitais = "";
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"address\": \"H\", " + 
                    " \"beds\": 896, " + 
                    " \"latitude\": \"_EM_1902_XYZ_\", " + 
                    " \"longitude\": \"_EM_1903_XYZ_\", " + 
                    " \"name\": \"_EM_1904_XYZ_\" " + 
                    " } ")
                .post(baseUrlOfSut + "/v1/hospitais/")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'name'", containsString("_EM_1904_XYZ_"))
                .body("'address'", containsString("H"))
                .body("'beds'", numberMatches(896.0))
                .body("'availableBeds'", numberMatches(0.0))
                .body("'longitude'", containsString("9.0284647"))
                .body("'latitude'", containsString("50.6080651"));
        location_hospitais = "/v1/hospitais/" + "/" + res_0.extract().body().path("id").toString();
        
        
        ValidatableResponse res_1 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"description\": \"TqTcP4NsTEtY\", " + 
                    " \"productName\": \"Ew\", " + 
                    " \"productType\": \"COMMON\", " + 
                    " \"quantity\": 413 " + 
                    " } ")
                .post(resolveLocation(location_hospitais, baseUrlOfSut + "/v1/hospitais/WKtkalXpscIAwP/estoque"))
                .then()
                .statusCode(405)
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(405.0))
                .body("'error'", containsString("Method Not Allowed"))
                .body("'message'", containsString("Request method 'POST' not supported"))
                .body("'path'", containsString("/v1/hospitais//665a32da747054613c92fd99"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_1.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_1() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/v1/hospitais/mrdL/pacientes/%5CEDi824_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("text/html");
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_2() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" \"BfndcAYlPOqfNlA\" ")
                .post(baseUrlOfSut + "/v1/hospitais/_EY_4G_XY%5C_/pacientes/checkout")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("text/html");
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_3() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/v1/hospitais/%5CpKfi45Bho/estoque/_EM_1_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("text/html");
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_4() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/v1/hospitais/blXHcY%5C/pacientes")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("text/html");
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_5() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/v1/hospitais/gjS%5CGbK31w1x2")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("text/html");
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_6() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/v1/hospitais/1/leitos?EMextraParam123=42")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(400.0))
                .body("'error'", containsString("Bad Request"))
                .body("'message'", containsString("Hospital não encontrado! ID:1"))
                .body("'path'", containsString("/v1/hospitais/1/leitos"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_7() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" 0 ")
                .post(baseUrlOfSut + "/v1/hospitais/null/transferencia/null?EMextraParam123=42")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(400.0))
                .body("'error'", containsString("Bad Request"))
                .body("'message'", containsString("Hospital não encontrado! ID:null"))
                .body("'path'", containsString("/v1/hospitais/null/transferencia/null"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_8() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .delete(baseUrlOfSut + "/v1/hospitais/664fc6b65c7d2553809c67b1?EMextraParam123=42")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 204, 403).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_9() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .delete(baseUrlOfSut + "/v1/hospitais/1/estoque/664fc6af5c7d2553809c67a6?EMextraParam123=42")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 204, 403).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_10() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/v1/hospitais/1/estoque?EMextraParam123=42")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_11() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/v1/hospitais/_EM_14_XYZ_/hospitaisProximos?raio=0.9840225882921698")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_12() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_22_XYZ_")
                .get(baseUrlOfSut + "/v1/hospitais/_EM_20_XYZ_/proximidades")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_13() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"active\": true, " + 
                    " \"birthDate\": \"2016-03-12T00:00:00\", " + 
                    " \"cpf\": \"cpf\", " + 
                    " \"exitDate\": \"2016-03-12T00:00:00\", " + 
                    " \"gender\": \"_EM_479_XYZ_\", " + 
                    " \"id\": \"1\", " + 
                    " \"location\": { " + 
                    " \"id\": \"foo\", " + 
                    " \"location\": { " + 
                    " \"coordinates\": [], " + 
                    " \"type\": \"foo\", " + 
                    " \"x\": 0.0, " + 
                    " \"y\": 0.0 " + 
                    " }, " + 
                    " \"locationCategory\": \"EVOMASTER\", " + 
                    " \"name\": \"foo\", " + 
                    " \"position\": { " + 
                    " \"coordinates\": [], " + 
                    " \"type\": \"foo\", " + 
                    " \"x\": 0.0, " + 
                    " \"y\": 0.0 " + 
                    " }, " + 
                    " \"referenceId\": \"foo\" " + 
                    " }, " + 
                    " \"name\": \"nome\" " + 
                    " } ")
                .post(baseUrlOfSut + "/v1/hospitais/_EM_478_XYZ_/pacientes/checkin")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(400.0))
                .body("'error'", containsString("Bad Request"))
                .body("'message'", containsString("JSON parse error: (was java.lang.NullPointerException); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: br.com.codenation.hospital.domain.Patient[\"location\"]->br.com.codenation.hospital.domain.Location[\"location\"])"))
                .body("'path'", containsString("/v1/hospitais/_EM_478_XYZ_/pacientes/checkin"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_14() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"active\": true, " + 
                    " \"birthDate\": \"2016-03-12T00:00:00\", " + 
                    " \"cpf\": \"foo\", " + 
                    " \"entryDate\": \"2016-03-12T00:00:00\", " + 
                    " \"exitDate\": \"2016-03-12T00:00:00\", " + 
                    " \"gender\": \"foo\", " + 
                    " \"id\": \"2\", " + 
                    " \"location\": { " + 
                    " \"id\": \"foo\", " + 
                    " \"location\": { " + 
                    " \"coordinates\": [], " + 
                    " \"type\": \"foo\", " + 
                    " \"x\": 0.0, " + 
                    " \"y\": 0.0 " + 
                    " }, " + 
                    " \"locationCategory\": \"EVOMASTER\", " + 
                    " \"name\": \"foo\", " + 
                    " \"position\": { " + 
                    " \"coordinates\": [], " + 
                    " \"type\": \"foo\", " + 
                    " \"x\": 0.0, " + 
                    " \"y\": 0.0 " + 
                    " }, " + 
                    " \"referenceId\": \"foo\" " + 
                    " }, " + 
                    " \"name\": \"foo\" " + 
                    " } ")
                .put(baseUrlOfSut + "/v1/hospitais/1/pacientes/2?EMextraParam123=42")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(400.0))
                .body("'error'", containsString("Bad Request"))
                .body("'message'", containsString("JSON parse error: (was java.lang.NullPointerException); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: br.com.codenation.hospital.domain.Patient[\"location\"]->br.com.codenation.hospital.domain.Location[\"location\"])"))
                .body("'path'", containsString("/v1/hospitais/1/pacientes/2"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_15() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"address\": \"_EM_1907_XYZ_\", " + 
                    " \"beds\": 575, " + 
                    " \"id\": \"F3HxW\", " + 
                    " \"latitude\": \"t\", " + 
                    " \"name\": \"_EM_1908_XYZ_\" " + 
                    " } ")
                .post(baseUrlOfSut + "/v1/hospitais/")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_16() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"description\": \"foo\", " + 
                    " \"id\": \"664fc6af5c7d2553809c67a7\", " + 
                    " \"name\": \"foo\", " + 
                    " \"productName\": \"foo\", " + 
                    " \"productType\": \"BLOOD\", " + 
                    " \"quantity\": 0 " + 
                    " } ")
                .put(baseUrlOfSut + "/v1/hospitais/1/estoque/664fc6af5c7d2553809c67a7?EMextraParam123=42")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_17() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"address\": \"_EM_548_XYZ_\", " + 
                    " \"availableBeds\": 470, " + 
                    " \"beds\": 479, " + 
                    " \"latitude\": \"_EM_746_XYZ_\", " + 
                    " \"longitude\": \"_EM_551_XYZ_\", " + 
                    " \"name\": \"\" " + 
                    " } ")
                .post(baseUrlOfSut + "/v1/hospitais/")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_18() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"description\": \"foo\", " + 
                    " \"id\": \"1\", " + 
                    " \"name\": \"foo\", " + 
                    " \"productName\": \"foo\", " + 
                    " \"productType\": \"BLOOD\", " + 
                    " \"quantity\": 0 " + 
                    " } ")
                .post(baseUrlOfSut + "/v1/hospitais/1/estoque?EMextraParam123=42")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_19() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"address\": \"\", " + 
                    " \"beds\": 304037927, " + 
                    " \"longitude\": \"_EM_783_XYZ_\", " + 
                    " \"name\": \"_EM_732_XYZ_\" " + 
                    " } ")
                .post(baseUrlOfSut + "/v1/hospitais/")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_20() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"address\": \"\", " + 
                    " \"availableBeds\": 0, " + 
                    " \"beds\": 0, " + 
                    " \"latitude\": \"_EM_2273_XYZ_\", " + 
                    " \"longitude\": \"_EM_719_XYZ_\", " + 
                    " \"name\": \"\" " + 
                    " } ")
                .put(baseUrlOfSut + "/v1/hospitais/DOE")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_21() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"address\": \"4RB36SQZHHyUA\", " + 
                    " \"beds\": -503263318, " + 
                    " \"latitude\": \"_EM_1548_XYZ_\", " + 
                    " \"longitude\": \"_EM_1549_XYZ_\", " + 
                    " \"name\": \"_EM_1550_XYZ_\" " + 
                    " } ")
                .post(baseUrlOfSut + "/v1/hospitais/")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_22() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"address\": \"\", " + 
                    " \"availableBeds\": 0, " + 
                    " \"beds\": 0, " + 
                    " \"latitude\": \"_EM_718_XYZ_\", " + 
                    " \"name\": \"_EM_720_XYZ_\" " + 
                    " } ")
                .put(baseUrlOfSut + "/v1/hospitais/_EM_716_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_23() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"address\": \"Rua dos Novos. 1000\", " + 
                    " \"availableBeds\": 10, " + 
                    " \"beds\": -8388598, " + 
                    " \"name\": \"_EM_1169_XYZ_\" " + 
                    " } ")
                .put(baseUrlOfSut + "/v1/hospitais/664fc6be5c7d2553809c67bd")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_24() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"address\": \"Rua dos Novos, 1000\", " + 
                    " \"availableBeds\": -246, " + 
                    " \"beds\": 14, " + 
                    " \"name\": \"Hospital Novo\" " + 
                    " } ")
                .put(baseUrlOfSut + "/v1/hospitais/6o6QG")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_25() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"address\": \"_EM_548_XYZ_\", " + 
                    " \"availableBeds\": -1073741573, " + 
                    " \"beds\": 479, " + 
                    " \"latitude\": \"_EM_745_XYZ_\", " + 
                    " \"longitude\": \"_EM_551_XYZ_\", " + 
                    " \"name\": \"_EM_552_XYZ_\" " + 
                    " } ")
                .post(baseUrlOfSut + "/v1/hospitais/")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_26() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" { " + 
                    " \"address\": \"Rua dos Novos, 1000\", " + 
                    " \"availableBeds\": 10, " + 
                    " \"beds\": 10, " + 
                    " \"name\": \"Hospital Novo\" " + 
                    " } ")
                .put(baseUrlOfSut + "/v1/hospitais/664fc6be5c7d2553809c67bd?EMextraParam123=42")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_27() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"address\": \"_EM_1571_XYZ_\", " + 
                    " \"availableBeds\": 609, " + 
                    " \"beds\": 688317032, " + 
                    " \"name\": \"_EM_1575_XYZ_\" " + 
                    " } ")
                .post(baseUrlOfSut + "/v1/hospitais/")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_28() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/v1/hospitais/1/pacientes/2?EMextraParam123=42")
                .then()
                .statusCode(404)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_29() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/v1/hospitais/1/pacientes?EMextraParam123=42")
                .then()
                .statusCode(404)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_30() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .contentType("application/json")
                .body(" \"1\" ")
                .post(baseUrlOfSut + "/v1/hospitais/1/pacientes/checkout?EMextraParam123=42")
                .then()
                .statusCode(404)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_31() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/v1/hospitais/664fc6c05c7d2553809c67bf?EMextraParam123=42")
                .then()
                .statusCode(404)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_32() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/v1/hospitais/1/estoque/0?EMextraParam123=42")
                .then()
                .statusCode(404)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_33() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_115_XYZ_")
                .contentType("application/json")
                .body(" { " + 
                    " \"exitDate\": \"2073-05-14T03:36:17\" " + 
                    " } ")
                .put(baseUrlOfSut + "/v1/hospitais/_EM_104_XYZ_/pacientes/_EM_105_XYZ_?EMextraParam123=_EM_114_XYZ_")
                .then()
                .statusCode(404)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_34() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/v1/hospitais/maisProximo?" + 
                    "lat=50.0&" + 
                    "lon=50.0&" + 
                    "raioMaximo=50000.0&" + 
                    "EMextraParam123=42")
                .then()
                .statusCode(404)
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(404.0))
                .body("'error'", containsString("Not Found"))
                .body("'message'", containsString("Nenhum hospital próximo com vagas encontrado!"))
                .body("'path'", containsString("/v1/hospitais/maisProximo"));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_35() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"active\": true, " + 
                    " \"birthDate\": \"1938-03-18T00:05:24\", " + 
                    " \"cpf\": \"_EM_1921_XYZ_\", " + 
                    " \"exitDate\": \"1969-05-16T02:16:25\", " + 
                    " \"gender\": \"_EM_1922_XYZ_\", " + 
                    " \"id\": \"qLr2_hlg8jXmhVb\", " + 
                    " \"location\": { " + 
                    " \"id\": \"_EM_1923_XYZ_\", " + 
                    " \"name\": \"_EM_1924_XYZ_\" " + 
                    " }, " + 
                    " \"name\": \"liBqM\" " + 
                    " } ")
                .post(baseUrlOfSut + "/v1/hospitais/_EM_1920_XYZ_/pacientes/checkin")
                .then()
                .statusCode(404)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_36() throws Exception {
        
        given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_45_XYZ_")
                .contentType("application/json")
                .body(" { " + 
                    " \"active\": false, " + 
                    " \"birthDate\": \"1954-09-26T13:01:37\", " + 
                    " \"cpf\": \"_EM_503_XYZ_\", " + 
                    " \"exitDate\": \"2097-07-32T24:60:51\", " + 
                    " \"gender\": \"_EM_504_XYZ_\", " + 
                    " \"id\": \"_EM_37_XYZ_\", " + 
                    " \"location\": { " + 
                    " \"id\": \"_EM_38_XYZ_\", " + 
                    " \"location\": { " + 
                    " \"x\": 0.9995001432032969, " + 
                    " \"y\": 0.9855007915148916 " + 
                    " }, " + 
                    " \"locationCategory\": \"HOSPITAL\", " + 
                    " \"name\": \"wJffw\", " + 
                    " \"position\": { " + 
                    " \"type\": \"_EM_41_XYZ_\", " + 
                    " \"x\": 0.191, " + 
                    " \"y\": 0.9072691249 " + 
                    " }, " + 
                    " \"referenceId\": \"_EM_42_XYZ_\" " + 
                    " } " + 
                    " } ")
                .post(baseUrlOfSut + "/v1/hospitais/_EM_34_XYZ_/pacientes/checkin?EMextraParam123=_EM_44_XYZ_")
                .then()
                .statusCode(404)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_37() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"description\": \"8\", " + 
                    " \"name\": \"McOdll2L2orwKxkU\", " + 
                    " \"productType\": \"BLOOD\", " + 
                    " \"quantity\": 585 " + 
                    " } ")
                .put(baseUrlOfSut + "/v1/hospitais/TBtq2Lj1iSuca/estoque/;Hq")
                .then()
                .statusCode(405)
                .assertThat()
                .contentType("application/json")
                .body("'status'", numberMatches(405.0))
                .body("'error'", containsString("Method Not Allowed"))
                .body("'message'", containsString("Request method 'PUT' not supported"))
                .body("'path'", containsString("/v1/hospitais/TBtq2Lj1iSuca/estoque/;Hq"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }


}
