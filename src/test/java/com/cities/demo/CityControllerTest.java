package com.cities.demo;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CityControllerTest {
    //Unit tests..

    @Test
    void callingAllVariableReturnsALl(){
        CityController cityController = new CityController(new TestService());

        var city = cityController.all();
        assertThat(city).contains(new CityDto(1,"Test")
                ,new CityDto(2,"Test2"));

    }
    @Test
    void callingForSearchingCityWithValidVariableReturnsForSearchingCity(){

    }

    @Test
    void callingOneWithValidCityIDReturnsOneCity(){
        CityController cityController = new CityController(new TestService());

        var city =cityController.one(1L);
        assertThat(city.getCityID()).isEqualTo(1);
        assertThat(city.getCapitalCity()).isEqualTo("Test");
    }
    @Test
    void callingOneWithInvalidCityIDThrowsExceptionWithResponseStatus404(){
        CityController cityController = new CityController(new TestService());
        assertThrows(ResponseStatusException.class, () ->cityController.one(2L));
    }
    @Test
    void callingCreateCityWithValidVariableReturnsOneCity() {

    }
    @Test
    void callingDeleteCityWithValidVariableReturnsOneCity() {

    }
    @Test
    void callingReplaceCityWithValidVariableReturnsOneCity(){

    }
    @Test
    void callingUpdateCityWithValidVariableReturnsOneCity(){

    }


}