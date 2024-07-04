package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.City;

public interface CityRepository extends JpaRepository<City, Long>{ //le proprietà della classe city sono le stesse del DB, le possiamo prendere come sono e modificarle

}