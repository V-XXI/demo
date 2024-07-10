package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Country;

public  interface CountryRepository extends JpaRepository<Country, Long>{

    //i need to create select and insert with jpaannotation for find all country and insert country

    @Query(value = "SELECT * FROM country", nativeQuery = true)
    List<Country> findAll();


    @Query(value = "SELECT * FROM countrysada WHERE country_id = ?1", nativeQuery = true)
    List<Country> findByCountryIdNative(Long countryId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO countrysada (country, last_update) VALUES (:country, :lastUpdate)", nativeQuery = true)
    void insertCountry(@Param("country") String country, @Param("lastUpdate") java.sql.Timestamp lastUpdate);
    
    
}
