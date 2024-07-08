package com.example.demo.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "actor")
public class Actor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name= "actor_id") // identifichiamo city_id come chiave primaria
    Long city_id;
    @Column(name= "first name")
    String city;
    @Column(name= "last_name")
    String country_id;
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
    public String getCountry_id() {
        return country_id;
    }
    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }
    public java.sql.Timestamp getLast_update() {
        return last_update;
    }
    public void setLast_update(java.sql.Timestamp last_update) {
        this.last_update = last_update;
    }
    
    public Actor(){}
    
}
