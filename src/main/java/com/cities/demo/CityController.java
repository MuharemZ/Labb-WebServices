package com.cities.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
public class CityController {

    private Service service;

    public CityController(Service service) {
        this.service = service;
    }

    @GetMapping("/cities")
    public List<CityDto> all() {
        return service.getAllCities();
    }

    @GetMapping("/cities/{cityID}")
    public CityDto one(@PathVariable Long cityID) {
        return service.getOne(cityID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, " cityID " + cityID + " not found."));
    }
    @RequestMapping("/cities/{searchTerm}")
    public List<CityDto> searchCity(@PathVariable String searchTerm)
    {return service.searchCity(searchTerm);
    }

    @PostMapping("/cities")
    @ResponseStatus(HttpStatus.CREATED)
    public CityDto createCity(@RequestBody CityDto cities) {
        return service.createCity(cities);
    }

    @DeleteMapping("/cities/{cityID}")
    public void deleteCity(@PathVariable long cityID) {
        service.deleteCity(cityID);
    }

    @PutMapping("/cities/{cityID}")
    public CityDto replaceCity(@RequestBody CityDto cityDto, @PathVariable Long cityID) {
        return service.replaceCity(cityID, cityDto);
    }

    @PatchMapping("/cities/{cityID}")
    public CityDto updateCity(@RequestBody CityDto cityDto, @PathVariable Long cityID) {
        return service.updateCity(cityID, cityDto);
    }
}


