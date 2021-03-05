package com.cities.demo;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class CityMapper {
    public CityMapper() {
    }

    public CityDto mapp(City city) {
        return new CityDto(city.getCityID(), city.getCapitalCity());
    }

    public City mapp(CityDto cityDto) {
        return new City(cityDto.getCityID(), cityDto.getCapitalCity());
    }

    public Optional<CityDto> mapp(Optional<City> optionalCities) {
        if (optionalCities.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalCities.get()));

    }

    public List<CityDto> mapp(List<City> all) {
        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }
}