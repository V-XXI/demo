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
    @Column (name= "actor_id") // identifichiamo actor_id come chiave primaria
    Long actor_id;
    @Column(name= "first_name")
    String first_name;
    @Column(name= "last_name")
    String last_name;
    @Column(name= "last_update")
    java.sql.Timestamp last_update;
    

    
    public Long getActor_id() {
        return actor_id;
    }



    public void setActor_id(Long actor_id) {
        this.actor_id = actor_id;
    }



    public String getFirst_name() {
        return first_name;
    }



    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }



    public String getLast_name() {
        return last_name;
    }



    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }



    public java.sql.Timestamp getLast_update() {
        return last_update;
    }



    public void setLast_update(java.sql.Timestamp last_update) {
        this.last_update = last_update;
    }



    public Actor(){}
    
}
