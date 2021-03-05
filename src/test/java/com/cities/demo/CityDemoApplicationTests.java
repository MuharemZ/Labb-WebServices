package com.cities.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CityDemoApplicationTests {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate testClient;

    @Test
    void contextLoads() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept","application/xml");
        var result = testClient.getForEntity("Http://localhost:" + port + "/cities/",CityDto[].class);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody().length).isGreaterThan(0);

    }
    @Test
    void postToService() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept","application/xml");

        CityDto cityDto = new CityDto(7,"Test7");
        var result = testClient.postForEntity("http://localhost:" + port + "/cities/",cityDto,CityDto.class);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
    @Test
    void getFromService() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept","application/xml");
        var result = testClient.getForEntity("http://localhost:" + port + "/cities/2",CityDto.class);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isEqualTo(new CityDto( 2 , "Test2"));
    }
}
