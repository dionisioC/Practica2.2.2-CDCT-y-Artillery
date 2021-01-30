package es.codeurjc.mastercloudapps.planner;

import es.codeurjc.mastercloudapps.planner.models.LandscapeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureStubRunner(ids = {"dcortesf:toposervice:+:stubs:8080"}, stubsMode = StubsMode.LOCAL)
public class ApplicationTests {

    @Test
    void verify_topo_service_madrid() {
        RestTemplate restTemplate = new RestTemplate();

        LandscapeResponse landscapeResponse = restTemplate.getForObject("http://localhost:8080/api/topographicdetails/Madrid", LandscapeResponse.class);

        assertEquals("Madrid", landscapeResponse.getId());
        assertEquals("Flat", landscapeResponse.getLandscape());
    }

    @Test
    void verify_topo_service_barcelona() {
        RestTemplate restTemplate = new RestTemplate();

        LandscapeResponse landscapeResponse = restTemplate.getForObject("http://localhost:8080/api/topographicdetails/Barcelona", LandscapeResponse.class);

        assertEquals("Barcelona", landscapeResponse.getId());
        assertEquals("Flat", landscapeResponse.getLandscape());
    }
}
