package com.example.demo.model;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name= "city_id") // identifichiamo city_id come chiave primaria
    Long city_id;
    @Column(name= "city")
    String city;
    @Column(name= "country_id")
    Long country_id;
    @Column(name= "last_update")
    java.sql.Timestamp last_update;
    
    public Long getCity_id() {
        return city_id;
    }
    public void setCity_id(Long city_id) {
        this.city_id = city_id;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Long getCountry_id() {
        return country_id;
    }
    public void setCountry_id(Long country_id) {
        this.country_id = country_id;
    }
    public java.sql.Timestamp getLast_update() {
        return last_update;
    }
    public void setLast_update(java.sql.Timestamp last_update) {
        this.last_update = last_update;
    }
    
    public City(){}
}
