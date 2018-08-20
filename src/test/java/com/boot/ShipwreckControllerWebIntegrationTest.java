package com.boot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ShipwreckControllerWebIntegrationTest {

    @Test
    public void testListAll() throws IOException {
        var restTemplate = new TestRestTemplate();
        var response = restTemplate.getForEntity("http://localhost:8080/api/v1/shipwrecks", String.class);

        assertThat( response.getStatusCode(), equalTo(HttpStatus.OK));

        var objectMapper = new ObjectMapper();
        var responseJson = objectMapper.readTree(response.getBody());

        assertThat( responseJson.isMissingNode(), is(false));
        assertThat( responseJson.toString(), equalTo("[]"));
    }
}
