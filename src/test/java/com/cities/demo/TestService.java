package com.cities.demo;

import java.util.List;
import java.util.Optional;

public class TestService implements Service {

    @Override
    public List<CityDto> getAllCities() {
        return List.of(new CityDto(1,"Test"),
                new CityDto(2,"Test2"));
    }

    @Override
    public Optional<CityDto> getOne(Long cityID) {
        if (cityID == 1)
        return Optional.of(new CityDto(1, "Test"));
        return Optional.empty();
    }

    @Override
    public List<CityDto> searchCity(String searchTerm) {

        return null;
    }

    @Override
    public CityDto createCity(CityDto City) {
        return null;
    }

    @Override
    public void deleteCity(Long cityID) {

    }

    @Override
    public CityDto replaceCity(Long cityID, CityDto cityDto) {
        return null;
    }

    @Override
    public CityDto updateCity(Long cityID, CityDto cityDto) {
        return null;
    }
}
