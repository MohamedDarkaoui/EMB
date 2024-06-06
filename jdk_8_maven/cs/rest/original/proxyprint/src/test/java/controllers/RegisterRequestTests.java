package controllers;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.proxyprint.kitchen.WebAppConfig;
import io.github.proxyprint.kitchen.models.Admin;
import io.github.proxyprint.kitchen.models.printshops.Manager;
import io.github.proxyprint.kitchen.models.printshops.RegisterRequest;
import io.github.proxyprint.kitchen.models.repositories.AdminDAO;
import io.github.proxyprint.kitchen.models.repositories.ManagerDAO;
import io.github.proxyprint.kitchen.models.repositories.PrintShopDAO;
import io.github.proxyprint.kitchen.models.repositories.RegisterRequestDAO;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = WebAppConfig.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = {
                "server.port=8080"
        }
)
public class RegisterRequestTests {

    @Autowired
    private AdminDAO admins;
    @Autowired
    private ManagerDAO managers;
    @Autowired
    private PrintShopDAO printshops;
    @Autowired
    private RegisterRequestDAO registerRequests;
    @Autowired
    private Gson GSON;

    private RestTemplate restTemplate;
    private String baseUrl;

    @Before
    public void setup() {
        this.restTemplate = new RestTemplate();
        this.baseUrl = "http://localhost:8080";
        this.admins.deleteAll();
        this.registerRequests.deleteAll();
    }

    private HttpHeaders createHeaders(String username, String password) {
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encode(auth.getBytes(Charset.forName("US-ASCII")));
            String authHeader = "Basic " + new String(encodedAuth);
            set("Authorization", authHeader);
        }};
    }

    private RegisterRequest addRegisterRequest(RegisterRequest rr) throws Exception {
        String body = GSON.toJson(rr);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl + "/request/register", request, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        String responseText = response.getBody();
        RegisterRequest responseRR = GSON.fromJson(responseText, RegisterRequest.class);

        rr.setId(responseRR.getId());
        assertEquals(rr, responseRR);

        return responseRR;
    }

    @Test
    public void registerRequestTest() throws Exception {
        RegisterRequest exampleRR = new RegisterRequest("manager", "manager", "proxyprint.pt.printshop@gmail.com", "1234", "address", 45d, 32d, "NIF", "name", false);
        addRegisterRequest(exampleRR);
    }

    @Test
    public void acceptRegisterRequest() throws Exception {
        // Test admin
        Admin admin = admins.save(new Admin("admin", "admin", "admin@mail.pt"));

        // Number of printshops before
        int pshopsBefore = (int) this.printshops.count();

        RegisterRequest exampleRR = new RegisterRequest("manager", "manager", "proxyprint.pt.printshop@gmail.com", "1234", "address", 45d, 32d, "NIF", "name", false);
        RegisterRequest rr = addRegisterRequest(exampleRR);

        HttpHeaders headers = createHeaders("admin", "admin");
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl + "/request/accept/" + rr.getId(), request, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        String responseText = response.getBody();
        JsonObject jsonObject = new JsonParser().parse(responseText).getAsJsonObject();
        boolean status = jsonObject.get("success").getAsBoolean();

        assertEquals(true, status);

        int pshopsAfter = (int) this.printshops.count();
        assertEquals(pshopsBefore + 1, pshopsAfter);

        Manager m = this.managers.findByUsername("manager");
        assertEquals("1234", m.getPassword());
    }

    @Test
    public void pendingRequestTest() throws Exception {
        // Test admin
        Admin admin = admins.save(new Admin("admin", "admin", "admin@mail.pt"));

        // Add directly to DAOs in this case
        RegisterRequest exampleRR = new RegisterRequest("manager1", "manager1", "proxyprint.pt.printshop@gmail.com", "1234", "address", 45d, 32d, "NIF", "name", false);
        RegisterRequest exampleRR1 = new RegisterRequest("manager", "manager", "proxyprint.pt.printshop@gmail.com", "1234", "address", 45d, 32d, "NIF", "name", true);
        this.registerRequests.save(exampleRR);
        this.registerRequests.save(exampleRR1);

        HttpHeaders headers = createHeaders("admin", "admin");
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(baseUrl + "/requests/pending", HttpMethod.GET, request, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        String responseText = response.getBody();
        Type listOfRR = new TypeToken<List<RegisterRequest>>() {}.getType();

        List<RegisterRequest> pending1 = this.registerRequests.findByAccepted(false);
        List<RegisterRequest> pending2 = GSON.fromJson(responseText, listOfRR);

        assertEquals(true, CollectionUtils.isEqualCollection(pending1, pending2));
    }
}
