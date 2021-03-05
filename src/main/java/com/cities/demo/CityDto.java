package com.cities.demo;

import java.util.Objects;

public class CityDto {
    private long cityID;
    private String capitalCity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDto cityDto = (CityDto) o;
        return cityID == cityDto.cityID && Objects.equals(capitalCity, cityDto.capitalCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityID, capitalCity);
    }

    public CityDto(long cityID, String capitalCity) {
        this.cityID = cityID;
        this.capitalCity = capitalCity;
    }

    public long getCityID() {
        return cityID;
    }

    public void setCityID(long cityID) {
        this.cityID = cityID;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }
}

