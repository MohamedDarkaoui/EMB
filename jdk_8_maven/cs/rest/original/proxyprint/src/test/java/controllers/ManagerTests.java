package controllers;

import com.google.gson.Gson;
import io.github.proxyprint.kitchen.WebAppConfig;
import io.github.proxyprint.kitchen.models.printshops.Employee;
import io.github.proxyprint.kitchen.models.printshops.Manager;
import io.github.proxyprint.kitchen.models.printshops.PrintShop;
import io.github.proxyprint.kitchen.models.repositories.AdminDAO;
import io.github.proxyprint.kitchen.models.repositories.ManagerDAO;
import io.github.proxyprint.kitchen.models.repositories.PrintShopDAO;
import io.github.proxyprint.kitchen.models.repositories.RegisterRequestDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Map;

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
public class ManagerTests {

    private static boolean SEEDED = false;

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
    public void setup() throws Exception {
        this.restTemplate = new RestTemplate();
        this.baseUrl = "http://localhost:8080";
        if (!SEEDED) {
            SEEDED = true;
            restTemplate.postForEntity(baseUrl + "/admin/seed", null, String.class);
        }
    }

    private HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encode(auth.getBytes(Charset.forName("US-ASCII")));
            String authHeader = "Basic " + new String(encodedAuth);
            set("Authorization", authHeader);
        }};
    }

    @Test
    public void _1addEmployee() throws Exception {
        Manager m = managers.findAll().iterator().next();
        PrintShop pshop = m.getPrintShop();
        long id = pshop.getId();

        Employee e = new Employee("jdc", "1234", "Daniel Caldas", pshop);
        String body = GSON.toJson(e);

        HttpHeaders headers = createHeaders(m.getUsername(), m.getPassword());
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl + "/printshops/" + id + "/employees", request, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        Map responseBody = GSON.fromJson(response.getBody(), Map.class);
        assertEquals(true, responseBody.get("success"));
    }

    @Test
    public void _2getEmployee() throws Exception {
        Manager m = managers.findAll().iterator().next();
        PrintShop pshop = m.getPrintShop();
        long id = pshop.getId();

        HttpHeaders headers = createHeaders(m.getUsername(), m.getPassword());

        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(baseUrl + "/printshops/" + id + "/employees", HttpMethod.GET, request, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
