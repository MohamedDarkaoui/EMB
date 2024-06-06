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
 * This file was automatically generated by EvoMaster on 2024-05-28T08:23:23.866+02:00[Europe/Paris]
 * <br>
 * The generated test suite contains 3 tests
 * <br>
 * Covered targets: 12949
 * <br>
 * Used time: 4h 15m 40s
 * <br>
 * Needed budget for current results: 99%
 * <br>
 * This file contains one example of each category of fault. The test cases in this file are a subset of the set of test cases likely to indicate faults.
 */
public class EvoMaster_fault_representatives_Test {

    
    private static final SutHandler controller = new em.embedded.org.languagetool.EmbeddedEvoMasterController();
    private static String baseUrlOfSut;
    /** [ems] - expectations master switch - is the variable that activates/deactivates expectations individual test cases
    * by default, expectations are turned off. The variable needs to be set to [true] to enable expectations
    */
    private static boolean ems = false;
    /**
    * sco - supported code oracle - checking that the response status code is among those supported according to the schema
    */
    private static boolean sco = false;
    /**
    * rso - response structure oracle - checking that the response objects match the responses defined in the schema
    */
    private static boolean rso = false;
    
    
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
    
    
    
    
    /**
    * [test_0_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * LastLine_0
    */
    @Test(timeout = 60000)
    public void test_0_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/x-www-form-urlencoded")
                .body("data=_EM_31_XYZ_&language=_EM_32_XYZ_&motherTongue=7fy7eLi&preferredVariants=_EM_34_XYZ_")
                .post(baseUrlOfSut + "/v2/check?EMextraParam123=_EM_39_XYZ_")
                .then()
                .statusCode(500) // org/languagetool/server/ApiV2_155_handleCheckRequest
                .assertThat()
                .body(containsString("Error: Internal Error: Unrecognized token '_EM_31_XYZ_': was expecting (JSON String, Number, Array, Object or token 'null', 'true' or 'false')\n at [Source: (String)\"_EM_31_XYZ_\"; line: 1, column: 12]"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_1() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .contentType("application/x-www-form-urlencoded")
                .body("text=fGHe%E2%80%99m&language=auto&altLanguages=sv&enabledRules=_EM_14029_XYZ_&disabledRules=uSiWN_OnKCG&enabledCategories=_EM_2283_XYZ_&disabledCategories=c")
                .post(baseUrlOfSut + "/v2/check")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'software'.'name'", containsString("LanguageTool"))
                .body("'software'.'version'", containsString("5.2-SNAPSHOT"))
                .body("'software'.'buildDate'", nullValue())
                .body("'software'.'apiVersion'", numberMatches(1.0))
                .body("'software'.'premium'", equalTo(false))
                .body("'software'.'premiumHint'", containsString("You might be missing errors only the Premium version can find. Contact us at support<at>languagetoolplus.com."))
                .body("'software'.'status'", containsString(""))
                .body("'warnings'.'incompleteResults'", equalTo(false))
                .body("'language'.'name'", containsString("English (US)"))
                .body("'language'.'code'", containsString("en-US"))
                .body("'language'.'detectedLanguage'.'name'", containsString("English (US)"))
                .body("'language'.'detectedLanguage'.'code'", containsString("en-US"))
                .body("'language'.'detectedLanguage'.'confidence'", numberMatches(0.64181894))
                .body("'matches'.size()", equalTo(1))
                .body("'matches'[0].'message'", containsString("This sentence does not start with an uppercase letter."))
                .body("'matches'[0].'shortMessage'", containsString(""))
                .body("'matches'[0].'replacements'.size()", equalTo(1))
                .body("'matches'[0].'replacements'[0].'value'", containsString("FGHe"))
                .body("'matches'[0].'offset'", numberMatches(0.0))
                .body("'matches'[0].'length'", numberMatches(4.0))
                .body("'matches'[0].'context'.'text'", containsString("fGHe’m"))
                .body("'matches'[0].'context'.'offset'", numberMatches(0.0))
                .body("'matches'[0].'context'.'length'", numberMatches(4.0))
                .body("'matches'[0].'sentence'", containsString("fGHe’m"))
                .body("'matches'[0].'type'.'typeName'", containsString("Other"))
                .body("'matches'[0].'rule'.'description'", containsString("Checks that a sentence starts with an uppercase letter"))
                .body("'matches'[0].'rule'.'issueType'", containsString("typographical"))
                .body("'matches'[0].'rule'.'category'.'name'", containsString("Capitalization"))
                .body("'matches'[0].'ignoreForIncompleteSentence'", equalTo(true))
                .body("'matches'[0].'contextForSureMatch'", numberMatches(-1.0));
        
        expectationHandler.expect(ems);
    }
    
    
    @Test(timeout = 60000)
    public void test_2() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/v2/rule/examples?" + 
                    "lang=BE&" + 
                    "ruleId=_EM_58_XYZ_&" + 
                    "EMextraParam123=_EM_2_XYZ_&" + 
                    "inputLogging=no&" + 
                    "apiKey=_EM_291_XYZ_&" + 
                    "tokenV2=J&" + 
                    "level=_EM_292_XYZ_&" + 
                    "useragent=_EM_293_XYZ_&" + 
                    "language=_EM_294_XYZ_&" + 
                    "mode=_EM_295_XYZ_&" + 
                    "instanceId=_EM_296_XYZ_&" + 
                    "v=_EM_62_XYZ_&" + 
                    "text=_EM_297_XYZ_&" + 
                    "username=klX_Af6wD8")
                .then()
                .statusCode(404)
                .assertThat()
                .body(containsString("Error: Rule '_EM_58_XYZ_' not found for language Belarusian (LanguageTool version/date: 5.2-SNAPSHOT/null, total rules of language: 12)"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }


}