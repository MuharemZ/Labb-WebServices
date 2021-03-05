package com.cities.demo;


import javax.persistence.*;

@Entity
@Table (name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cityID;
    private String capitalCity;

    public City(long cityID, String capitalCity) {
        this.cityID = cityID;
        this.capitalCity = capitalCity;
    }

    public City() {

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
