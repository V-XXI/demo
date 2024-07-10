package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Country;

public  interface CountryRepository extends JpaRepository<Country, Long>{
//add query sql to f in all country
@Query(value = "SELECT * FROM country", nativeQuery = true) //per operare sulla query
List<Country> findAll();

//add query sql to f ind city by id
@Query(value = "SELECT * FROM country WHERE country_id = ?1", nativeQuery = true) 
List<Country> findByCountryIdNative(Long countryId); //copiare in 

//add query sql to insert city
@Modifying
@Transactional
@Query(value = "INSERT INTO country (country, last_update) VALUES (:country, :lastUpdate)", nativeQuery = true)
void insertCountry(@Param("country") String country, @Param ("lastUpdate") java.sql.Timestamp lastUpdate);

}


