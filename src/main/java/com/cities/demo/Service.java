package com.cities.demo;

import java.util.List;
import java.util.Optional;

public interface Service {
    List<CityDto> getAllCities();

    Optional<CityDto> getOne(Long cityID);

    CityDto createCity(CityDto cities);

    void deleteCity(Long cityID);

    CityDto replaceCity(Long cityID, CityDto cityDto);

    CityDto updateCity(Long cityID, CityDto cityDto);

    List<CityDto> searchCity(String searchTerm);
}
