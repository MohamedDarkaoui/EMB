package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.proxyprint.kitchen.WebAppConfig;
import io.github.proxyprint.kitchen.models.User;
import io.github.proxyprint.kitchen.models.repositories.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertTrue;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = WebAppConfig.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = {
                "server.port=8080"
        }
)
public class ConsumerTests {

    @Autowired
    private UserDAO users;
    @Autowired
    private Gson GSON;

    private RestTemplate restTemplate;
    private String baseUrl;

    @Before
    public void setup() {
        this.restTemplate = new RestTemplate();
        this.restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        this.baseUrl = "http://localhost:8080";
    }

    @Test
    public void registerUser() throws Exception {
        String url = baseUrl + "/consumer/register";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", "testusername");
        params.add("password", "testpassword");
        params.add("name", "testname");
        params.add("email", "testemail@mail.pt");
        params.add("latitude", "testlat");
        params.add("longitude", "testlong");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, new HttpHeaders());
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        JsonObject jsonObject = new JsonParser().parse(response.getBody()).getAsJsonObject();
        boolean status = jsonObject.get("success").getAsBoolean();

        assertTrue(status);
    }

    @Test
    public void login() throws Exception {
        String url = baseUrl + "/login";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", "testusername");
        params.add("password", "testpassword");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, new HttpHeaders());
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        JsonObject jsonObject = new JsonParser().parse(response.getBody()).getAsJsonObject();
        boolean status = jsonObject.get("success").getAsBoolean();

        assertTrue(status);
    }

    @Test
    public void errorRegisterUser() throws Exception {
        String url = baseUrl + "/consumer/register";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", "testusername");
        params.add("password", "testpassword");
        params.add("name", "testname");
        params.add("email", "testemail@mail.pt");
        params.add("latitude", "testlat");
        params.add("longitude", "testlong");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, new HttpHeaders());
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        JsonObject jsonObject = new JsonParser().parse(response.getBody()).getAsJsonObject();
        boolean status = !jsonObject.get("success").getAsBoolean();

        assertTrue(status);

        User user = this.users.findByUsername("testusername");
        this.users.delete(user);
    }
}
