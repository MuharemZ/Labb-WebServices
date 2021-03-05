package com.cities.demo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class CityService implements com.cities.demo.Service {

    private final CityMapper cityMapper;
    private CityRepository cityRepository;


    public CityService(CityRepository cityRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;

    }


    @Override
    public List<CityDto> getAllCities() {
        return cityMapper.mapp(cityRepository.findAll());
    }

    @Override
    public Optional<CityDto> getOne(Long cityID) {
        return cityMapper.mapp(cityRepository.findById(cityID));
    }

    @Override
    public CityDto createCity(CityDto cities) {
        if (cities.getCapitalCity().isEmpty())
            throw new RuntimeException();
        return cityMapper.mapp(cityRepository.save(cityMapper.mapp(cities)));
    }

    @Override
    public void deleteCity(Long cityID) {
        cityRepository.deleteById(cityID);
    }

    @Override
    public CityDto replaceCity(Long cityID, CityDto cityDto) {
        Optional<City> city = cityRepository.findById(cityID);
        if (city.isPresent()) {
            City updatedCity = city.get();
            updatedCity.setCapitalCity(cityDto.getCapitalCity());
            return cityMapper.mapp(cityRepository.save(updatedCity));
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "cityId" + cityID + "not found in the list.");
    }

    @Override
    public CityDto updateCity(Long cityID, CityDto cityDto) {
        Optional<City> city = cityRepository.findById(cityID);
        if (city.isPresent()) {
            City updatedCity = city.get();
            if (cityDto.getCapitalCity()!= null)
            updatedCity.setCapitalCity(cityDto.getCapitalCity());
            return cityMapper.mapp(cityRepository.save(updatedCity));
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "cityId" + cityID + "not found in the list.");
    }

    @Override
    public List<CityDto> searchCity(String searchTerm) {
        if (searchTerm.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " City " + searchTerm + " couldn't found the city in database.");
                return cityMapper.mapp(cityRepository.findAllByCapitalCity(searchTerm));

    }
}

