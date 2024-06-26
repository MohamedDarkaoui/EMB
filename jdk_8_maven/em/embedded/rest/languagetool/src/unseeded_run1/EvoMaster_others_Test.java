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
 * This file was automatically generated by EvoMaster on 2024-05-28T08:23:23.837+02:00[Europe/Paris]
 * <br>
 * The generated test suite contains 28 tests
 * <br>
 * Covered targets: 4227
 * <br>
 * Used time: 4h 15m 40s
 * <br>
 * Needed budget for current results: 99%
 * <br>
 * This file contains test cases that represent failed calls, but not indicative of faults.
 */
public class EvoMaster_others_Test {

    
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
        
        try{
            given().accept("*/*")
                    .header("x-EMextraHeader123", "rVs_VsaLALu")
                    .get(baseUrlOfSut + "/v2/configinfo?" + 
                        "language=DE&" + 
                        "EMextraParam123=_EM_905_XYZ_&" + 
                        "mode=WitC8&" + 
                        "instanceId=_EM_907_XYZ_&" + 
                        "inputLogging=_EM_908_XYZ_&" + 
                        "apiKey=&" + 
                        "tokenV2=_EM_910_XYZ_&" + 
                        "level=_EM_1318_XYZ_&" + 
                        "v=_EM_1319_XYZ_&" + 
                        "useragent=_EM_1320_XYZ_&" + 
                        "text=_EM_912_XYZ_&" + 
                        "username=_EM_913_XYZ_");
        } catch(Exception e){
        }
    }
    
    
    @Test(timeout = 60000)
    public void test_1() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        try{
            given().accept("*/*")
                    .header("x-EMextraHeader123", "")
                    .contentType("application/x-www-form-urlencoded")
                    .body("text=9Wsrb8&language=auto&altLanguages=uk-UA&enabledRules=_EM_2281_XYZ_&disabledRules=_EM_14851_XYZ_&disabledCategories=_EM_2284_XYZ_")
                    .post(baseUrlOfSut + "/v2/check");
        } catch(Exception e){
        }
    }
    
    
    @Test(timeout = 60000)
    public void test_2() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_251_XYZ_")
                .contentType("application/x-www-form-urlencoded")
                .body("language=_EM_242_XYZ_&motherTongue=_EM_244_XYZ_&enabledRules=_EM_246_XYZ_&disabledRules=_EM_247_XYZ_&enabledCategories=_EM_248_XYZ_&disabledCategories=_EM_249_XYZ_")
                .post(baseUrlOfSut + "/v2/check?EMextraParam123=_EM_250_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: Missing 'text' or 'data' parameter"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_3() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_7_XYZ_")
                .get(baseUrlOfSut + "/v2/check?" + 
                    "text=_EM_2587_XYZ_&" + 
                    "language=pL&" + 
                    "disabledRules=zztzeHAN2BD65Y&" + 
                    "EMextraParam123=aWzlP&" + 
                    "preferredVariants=_EM_1070_XYZ_&" + 
                    "data=_EM_2588_XYZ_&" + 
                    "apiKey=_EM_1072_XYZ_&" + 
                    "inputLogging=_EM_1073_XYZ_&" + 
                    "tokenV2=VW&" + 
                    "level=_EM_2589_XYZ_&" + 
                    "ruleValues=_EM_1076_XYZ_&" + 
                    "useragent=kFSY7AdOF8J8NrWS&" + 
                    "noopLanguages=_EM_1078_XYZ_&" + 
                    "enabled=_EM_1079_XYZ_&" + 
                    "token=_EM_1080_XYZ_&" + 
                    "mode=all&" + 
                    "password=_EM_2590_XYZ_&" + 
                    "autodetect=_EM_1082_XYZ_&" + 
                    "instanceId=_EM_1083_XYZ_&" + 
                    "filterDictionaryMatches=Ia&" + 
                    "v=_EM_2591_XYZ_&" + 
                    "preferredLanguages=_EM_2592_XYZ_&" + 
                    "textSessionId=_EM_1087_XYZ_&" + 
                    "disabled=_EM_2593_XYZ_&" + 
                    "preferredvariants=gF2jJh4YHoRocVq&" + 
                    "username=_EM_1090_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: Set only 'text' or 'data' parameter, not both"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_4() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/x-www-form-urlencoded")
                .body("word=_EM_1571_XYZ_&username=&apiKey=_EM_1572_XYZ_")
                .post(baseUrlOfSut + "/v2/words/delete?EMextraParam123=_EM_1228_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: username must be set"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_5() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/v2/configinfo?" + 
                    "language=De-%5CE%28d%7CD%29%28e%7CE%29%5CQ-%5CE%28x%7CX%29%5CQ-%5CE%28s%7CS%29%28i%7CI%29%28m%7CM%29%28p%7CP%29%28l%7CL%29%28e%7CE%29%5CQ-LanGUAge&" + 
                    "mode=all&" + 
                    "instanceId=G2Zif&" + 
                    "inputLogging=no&" + 
                    "apiKey=_EM_10392_XYZ_&" + 
                    "tokenV2=QV&" + 
                    "level=picky&" + 
                    "v=_EM_10401_XYZ_&" + 
                    "useragent=_EM_10403_XYZ_&" + 
                    "text=_EM_7953_XYZ_&" + 
                    "username=UElYE10rglxA")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: 'De-\\E(d|D)(e|E)\\Q-\\E(x|X)\\Q-\\E(s|S)(i|I)(m|M)(p|P)(l|L)(e|E)\\Q-LanGUAge' isn't a valid language code"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_6() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_24_XYZ_")
                .contentType("application/x-www-form-urlencoded")
                .body("word=_EM_21_XYZ_&username=_EM_22_XYZ_&apiKey=_EM_23_XYZ_")
                .post(baseUrlOfSut + "/v2/words/add?EMextraParam123=42")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: No user found for given username '_EM_22_XYZ_' and given api key"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_7() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/v2/check?" + 
                    "text=_EM_370_XYZ_&" + 
                    "language=_EM_371_XYZ_&" + 
                    "EMextraParam123=_EM_6_XYZ_&" + 
                    "preferredVariants=_EM_373_XYZ_&" + 
                    "apiKey=_EM_375_XYZ_&" + 
                    "inputLogging=_EM_376_XYZ_&" + 
                    "token=_EM_382_XYZ_&" + 
                    "autodetect=_EM_385_XYZ_&" + 
                    "instanceId=_EM_386_XYZ_&" + 
                    "textSessionId=_EM_390_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: You specified 'autodetect' but automatic language detection is now activated with 'language=auto' in v2 of the API"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_8() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_29_XYZ_")
                .contentType("application/x-www-form-urlencoded")
                .body("word=_EM_25_XYZ_&username=_EM_26_XYZ_&apiKey=_EM_27_XYZ_")
                .post(baseUrlOfSut + "/v2/words/delete?EMextraParam123=_EM_28_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: No user found for given username '_EM_26_XYZ_' and given api key"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_9() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/v2/check?" + 
                    "text=fiKYg2TIQUiIwKCe&" + 
                    "language=oe92y3gU&" + 
                    "EMextraParam123=_EM_2809_XYZ_&" + 
                    "apiKey=_EM_2813_XYZ_&" + 
                    "token=_EM_2820_XYZ_&" + 
                    "mode=_EM_2821_XYZ_&" + 
                    "autodetect=_EM_2823_XYZ_&" + 
                    "filterDictionaryMatches=_EM_2824_XYZ_&" + 
                    "textSessionId=_EM_2826_XYZ_&" + 
                    "preferredvariants=_EM_2828_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: You specified 'preferredvariants' but the parameter is now called 'preferredVariants' (uppercase 'V') in v2 of the API"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_10() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_24_XYZ_")
                .contentType("application/x-www-form-urlencoded")
                .body("word=_EM_2573_XYZ_&username=_EM_2574_XYZ_&apiKey=_EM_2575_XYZ_")
                .post(baseUrlOfSut + "/v2/words/add?EMextraParam123=42")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: No user found for given username '_EM_2574_XYZ_' and given api key"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
        
        ValidatableResponse res_1 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_24_XYZ_")
                .contentType("application/x-www-form-urlencoded")
                .body("word=Ywg4fViXY19Q&username=haVyophSdK1b&apiKey=")
                .post(baseUrlOfSut + "/v2/words/add?" + 
                    "level=_EM_2578_XYZ_&" + 
                    "useragent=_EM_2579_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: apiKey must be set"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_1.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_11() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/v2/words?" + 
                    "username=QcUrUQ409L&" + 
                    "apiKey=_EM_554_XYZ_&" + 
                    "offset=413&" + 
                    "limit=881&" + 
                    "EMextraParam123=_EM_69_XYZ_&" + 
                    "inputLogging=R_wO5iezIp&" + 
                    "level=_EM_556_XYZ_&" + 
                    "useragent=_EM_557_XYZ_&" + 
                    "language=_EM_558_XYZ_&" + 
                    "mode=_EM_560_XYZ_&" + 
                    "password=_EM_561_XYZ_&" + 
                    "instanceId=_EM_562_XYZ_&" + 
                    "text=_EM_564_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: No user found for given username 'QcUrUQ409L' and given api key"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_12() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_12_XYZ_")
                .get(baseUrlOfSut + "/v2/configinfo?language=CBSscwrXu")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: 'CBSscwrXu' is not a language code known to LanguageTool. Supported language codes are: ar, ast-ES, be-BY, br-FR, ca-ES, ca-ES-valencia, da-DK, de, de-AT, de-CH, de-DE, de-DE-x-simple-language, el-GR, en, en-AU, en-CA, en-GB, en-NZ, en-US, en-ZA, eo, es, fa, fr, ga-IE, gl-ES, it, ja-JP, km-KH, nl, pl-PL, pt, pt-AO, pt-BR, pt-MZ, pt-PT, ro-RO, ru-RU, sk-SK, sl-SI, sv, ta-IN, tl-PH, uk-UA, zh-CN. The list of languages is read from META-INF/org/languagetool/language-module.properties in the Java classpath. See https://dev.languagetool.org/java-api for details."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_13() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/v2/rule/examples?" + 
                    "lang=_EM_0_XYZ_&" + 
                    "ruleId=_EM_1_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: '_EM_0_XYZ_' is not a language code known to LanguageTool. Supported language codes are: ar, ast-ES, be-BY, br-FR, ca-ES, ca-ES-valencia, da-DK, de, de-AT, de-CH, de-DE, de-DE-x-simple-language, el-GR, en, en-AU, en-CA, en-GB, en-NZ, en-US, en-ZA, eo, es, fa, fr, ga-IE, gl-ES, it, ja-JP, km-KH, nl, pl-PL, pt, pt-AO, pt-BR, pt-MZ, pt-PT, ro-RO, ru-RU, sk-SK, sl-SI, sv, ta-IN, tl-PH, uk-UA, zh-CN. The list of languages is read from META-INF/org/languagetool/language-module.properties in the Java classpath. See https://dev.languagetool.org/java-api for details."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_14() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_3624_XYZ_")
                .contentType("application/x-www-form-urlencoded")
                .body("text=_EM_3615_XYZ_&language=_EM_3617_XYZ_&preferredVariants=_EM_3620_XYZ_&enabledCategories=35YqW35ns&enabledOnly=true")
                .post(baseUrlOfSut + "/v2/check?EMextraParam123=_EM_3623_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: You specified 'preferredVariants' but you didn't specify 'language=auto'"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_15() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/v2/rule/examples?" + 
                    "lang=-x-&" + 
                    "ruleId=WHITESPACE_RULE&" + 
                    "EMextraParam123=_EM_2_XYZ_&" + 
                    "inputLogging=_EM_59_XYZ_&" + 
                    "apiKey=_EM_317_XYZ_&" + 
                    "tokenV2=_EM_314_XYZ_&" + 
                    "level=default&" + 
                    "useragent=YtVFEs65vS&" + 
                    "language=_EM_318_XYZ_&" + 
                    "mode=textLevelOnly&" + 
                    "instanceId=1&" + 
                    "v=Xv5Rm&" + 
                    "text=_EM_319_XYZ_&" + 
                    "username=_EM_320_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: '-x-' is not a language code known to LanguageTool. Supported language codes are: ar, ast-ES, be-BY, br-FR, ca-ES, ca-ES-valencia, da-DK, de, de-AT, de-CH, de-DE, de-DE-x-simple-language, el-GR, en, en-AU, en-CA, en-GB, en-NZ, en-US, en-ZA, eo, es, fa, fr, ga-IE, gl-ES, it, ja-JP, km-KH, nl, pl-PL, pt, pt-AO, pt-BR, pt-MZ, pt-PT, ro-RO, ru-RU, sk-SK, sl-SI, sv, ta-IN, tl-PH, uk-UA, zh-CN. The list of languages is read from META-INF/org/languagetool/language-module.properties in the Java classpath. See https://dev.languagetool.org/java-api for details."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_16() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/v2/rule/examples?" + 
                    "lang=-x-&" + 
                    "ruleId=_EM_58_XYZ_9&" + 
                    "EMextraParam123=_EM_2_XYZ_&" + 
                    "inputLogging=_EM_59_XYZ_&" + 
                    "apiKey=_EM_63_XYZ_&" + 
                    "tokenV2=&" + 
                    "level=_EM_60_XYZ_&" + 
                    "useragent=YtVFEs65vS&" + 
                    "language=RD&" + 
                    "mode=_EM_64_XYZ_&" + 
                    "instanceId=1&" + 
                    "v=Xv5Rm&" + 
                    "text=kqZbbBkKOqMgyqc&" + 
                    "username=klX_Af6wD8")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: '-x-' is not a language code known to LanguageTool. Supported language codes are: ar, ast-ES, be-BY, br-FR, ca-ES, ca-ES-valencia, da-DK, de, de-AT, de-CH, de-DE, de-DE-x-simple-language, el-GR, en, en-AU, en-CA, en-GB, en-NZ, en-US, en-ZA, eo, es, fa, fr, ga-IE, gl-ES, it, ja-JP, km-KH, nl, pl-PL, pt, pt-AO, pt-BR, pt-MZ, pt-PT, ro-RO, ru-RU, sk-SK, sl-SI, sv, ta-IN, tl-PH, uk-UA, zh-CN. The list of languages is read from META-INF/org/languagetool/language-module.properties in the Java classpath. See https://dev.languagetool.org/java-api for details."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_17() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/x-www-form-urlencoded")
                .body("text=_EM_97_XYZ_&language=_EM_99_XYZ_&motherTongue=_EM_101_XYZ_&preferredVariants=_EM_102_XYZ_&enabledRules=Eud7yC&disabledRules=_EM_103_XYZ_&disabledCategories=_EM_105_XYZ_")
                .post(baseUrlOfSut + "/v2/check?EMextraParam123=42")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: You specified 'preferredVariants' but you didn't specify 'language=auto'"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
        
        ValidatableResponse res_1 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/x-www-form-urlencoded")
                .body("text=_EM_106_XYZ_&language=_EM_108_XYZ_&altLanguages=_EM_109_XYZ_&preferredVariants=_EM_111_XYZ_&enabledRules=_EM_112_XYZ_&enabledCategories=_EM_113_XYZ_&disabledCategories=FOi")
                .post(baseUrlOfSut + "/v2/check?" + 
                    "apiKey=_EM_114_XYZ_&" + 
                    "inputLogging=_EM_115_XYZ_&" + 
                    "enabled=gcVT&" + 
                    "mode=_EM_121_XYZ_&" + 
                    "autodetect=_EM_122_XYZ_&" + 
                    "instanceId=_EM_123_XYZ_&" + 
                    "filterDictionaryMatches=_EM_124_XYZ_&" + 
                    "v=1iaVorf&" + 
                    "textSessionId=_EM_126_XYZ_&" + 
                    "username=fsMCkBeP1tBQt5P")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: You specified 'enabled' but the parameter is now called 'enabledRules' in v2 of the API"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_1.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_18() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/x-www-form-urlencoded")
                .body("text=%E5%80%8B%E4%BA%BA&language=auto&altLanguages=uk-UA&preferredVariants=_EM_2280_XYZ_&enabledRules=2k5bD26Q4&disabledRules=2k5bD26Q4&enabledCategories=_EM_2283_XYZ_&disabledCategories=CpFYglmz")
                .post(baseUrlOfSut + "/v2/check")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: Invalid format for 'preferredVariants', expected a dash as in 'en-GB': '_EM_2280_XYZ_'"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_19() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/x-www-form-urlencoded")
                .body("text=&language=-x-&altLanguages=xx&enabledRules=2k5bD26Q4&disabledRules=1k5bD26Q4&enabledCategories=_EM_2283_XYZ_&disabledCategories=CpF%5Bglmz")
                .post(baseUrlOfSut + "/v2/check")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: '-x-' is not a language code known to LanguageTool. Supported language codes are: ar, ast-ES, be-BY, br-FR, ca-ES, ca-ES-valencia, da-DK, de, de-AT, de-CH, de-DE, de-DE-x-simple-language, el-GR, en, en-AU, en-CA, en-GB, en-NZ, en-US, en-ZA, eo, es, fa, fr, ga-IE, gl-ES, it, ja-JP, km-KH, nl, pl-PL, pt, pt-AO, pt-BR, pt-MZ, pt-PT, ro-RO, ru-RU, sk-SK, sl-SI, sv, ta-IN, tl-PH, uk-UA, zh-CN. The list of languages is read from META-INF/org/languagetool/language-module.properties in the Java classpath. See https://dev.languagetool.org/java-api for details."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_20() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/v2/check?" + 
                    "text=_EM_3_XYZ_&" + 
                    "language=_EM_4_XYZ_&" + 
                    "disabledRules=_EM_5_XYZ_&" + 
                    "EMextraParam123=_EM_6_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: '_EM_4_XYZ_' is not a language code known to LanguageTool. Supported language codes are: ar, ast-ES, be-BY, br-FR, ca-ES, ca-ES-valencia, da-DK, de, de-AT, de-CH, de-DE, de-DE-x-simple-language, el-GR, en, en-AU, en-CA, en-GB, en-NZ, en-US, en-ZA, eo, es, fa, fr, ga-IE, gl-ES, it, ja-JP, km-KH, nl, pl-PL, pt, pt-AO, pt-BR, pt-MZ, pt-PT, ro-RO, ru-RU, sk-SK, sl-SI, sv, ta-IN, tl-PH, uk-UA, zh-CN. The list of languages is read from META-INF/org/languagetool/language-module.properties in the Java classpath. See https://dev.languagetool.org/java-api for details."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_21() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/x-www-form-urlencoded")
                .body("text=_EM_16289_XYZ_&language=-%5CE%28x%7CX%29%5CQ-&altLanguages=-x-&enabledRules=QSk&disabledRules=_EM_16288_XYZ_&enabledCategories=_EM_2283_XYZ_&disabledCategories=_EM_2284_XYZ_")
                .post(baseUrlOfSut + "/v2/check")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: '-\\E(x|X)\\Q-' is not a language code known to LanguageTool. Supported language codes are: ar, ast-ES, be-BY, br-FR, ca-ES, ca-ES-valencia, da-DK, de, de-AT, de-CH, de-DE, de-DE-x-simple-language, el-GR, en, en-AU, en-CA, en-GB, en-NZ, en-US, en-ZA, eo, es, fa, fr, ga-IE, gl-ES, it, ja-JP, km-KH, nl, pl-PL, pt, pt-AO, pt-BR, pt-MZ, pt-PT, ro-RO, ru-RU, sk-SK, sl-SI, sv, ta-IN, tl-PH, uk-UA, zh-CN. The list of languages is read from META-INF/org/languagetool/language-module.properties in the Java classpath. See https://dev.languagetool.org/java-api for details."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_22() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/x-www-form-urlencoded")
                .body("text=_EM_11080_XYZ_&language=auto&altLanguages=pCI&motherTongue=Tl&enabledRules=_EM_2281_XYZ_&disabledRules=mt_aY9JcIb&enabledCategories=My&disabledCategories=_EM_2284_XYZ_")
                .post(baseUrlOfSut + "/v2/check")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: 'pCI' is not a language code known to LanguageTool. Supported language codes are: ar, ast-ES, be-BY, br-FR, ca-ES, ca-ES-valencia, da-DK, de, de-AT, de-CH, de-DE, de-DE-x-simple-language, el-GR, en, en-AU, en-CA, en-GB, en-NZ, en-US, en-ZA, eo, es, fa, fr, ga-IE, gl-ES, it, ja-JP, km-KH, nl, pl-PL, pt, pt-AO, pt-BR, pt-MZ, pt-PT, ro-RO, ru-RU, sk-SK, sl-SI, sv, ta-IN, tl-PH, uk-UA, zh-CN. The list of languages is read from META-INF/org/languagetool/language-module.properties in the Java classpath. See https://dev.languagetool.org/java-api for details."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_23() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/x-www-form-urlencoded")
                .body("text=U_or%60&language=bR&altLanguages=ta&enabledRules=Un7dDMfF&disabledRules=Jb23ZrMrK&disabledCategories=&enabledOnly=true")
                .post(baseUrlOfSut + "/v2/check")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: Category id must not be empty: ''"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_24() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/x-www-form-urlencoded")
                .body("text=9_srb&language=bR&altLanguages=uk-UA&enabledRules=2k5bD26Q4&disabledRules=2k5bD26Q4&disabledCategories=_EM_12973_XYZ_&enabledOnly=true")
                .post(baseUrlOfSut + "/v2/check")
                .then()
                .statusCode(400)
                .assertThat()
                .body(containsString("Error: You cannot specify disabled rules or categories using enabledOnly=true"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_25() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/v2/rule/examples?" + 
                    "lang=aSt&" + 
                    "ruleId=_EM_313_XYZ_&" + 
                    "inputLogging=_EM_59_XYZ_&" + 
                    "apiKey=_EM_63_XYZ_&" + 
                    "tokenV2=_EM_314_XYZ_&" + 
                    "level=KrfkWY38&" + 
                    "useragent=YtVFEs65vS&" + 
                    "language=RD&" + 
                    "mode=textLevelOnly&" + 
                    "instanceId=1&" + 
                    "v=Xv5Rm&" + 
                    "text=_EM_315_XYZ_&" + 
                    "username=_EM_316_XYZ_")
                .then()
                .statusCode(404)
                .assertThat()
                .body(containsString("Error: Rule '_EM_313_XYZ_' not found for language Asturian (LanguageTool version/date: 5.2-SNAPSHOT/null, total rules of language: 67)"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_26() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/v2/rule/examples?" + 
                    "lang=aSt&" + 
                    "ruleId=_EM_58_XYZ_&" + 
                    "inputLogging=_EM_59_XYZ_&" + 
                    "apiKey=eprqdA9ntO&" + 
                    "tokenV2=&" + 
                    "level=_EM_60_XYZ_&" + 
                    "useragent=YtVFEs65vS&" + 
                    "language=_EM_61_XYZ_&" + 
                    "mode=%5BVk&" + 
                    "instanceId=1&" + 
                    "v=_EM_62_XYZ_&" + 
                    "text=kqZbbBkKOqMgyqc&" + 
                    "username=klX_Af6wD8")
                .then()
                .statusCode(404)
                .assertThat()
                .body(containsString("Error: Rule '_EM_58_XYZ_' not found for language Asturian (LanguageTool version/date: 5.2-SNAPSHOT/null, total rules of language: 67)"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_27() throws Exception {
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
