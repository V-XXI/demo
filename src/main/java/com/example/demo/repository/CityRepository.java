// package com.example.demo.repository;

// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
// import org.springframework.transaction.annotation.Transactional;

// import com.example.demo.model.City;

// public interface CityRepository extends JpaRepository<City, Long>{ //le proprietà della classe city sono le stesse del DB, le possiamo prendere come sono e modificarle
// //add query sql to f in all city
// @Query(value = "SELECT * FROM city", nativeQuery = true) //per operare sulla query
// List<City> findAll();

// //add query sql to f ind city by id
// @Query(value = "SELECT • FROM city WHERE country_id = ?1", nativeQuery = true) 
// List<City> findbyCountryIdNative(Long countryId); //copiare in 

// //add query sql to insert city
// @Modifying
// @Transactional
// @Query(value = "INSERT INTO city (city, country_id, last_update) VALUES (:city, :country_id, :last_update)", nativeQuery = true)
// void insertCity(@Param("city") String city, @Param("countryId") Long country_id, @Param ("lastUpdate") java.sql.Timestamp lastUpdate);

// }





package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.City;

public interface CityRepository extends JpaRepository<City, Long>{

    //add query sql to fin all city
    @Query(value = "SELECT * FROM city", nativeQuery = true)
    List<City> findAll();

    //add query sql to find city by id
    @Query(value = "SELECT * FROM city WHERE city = ?1", nativeQuery = true)
    List<City> findByCityIdNative(Long cityId);

    //add query sql to insert city
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO city (city, country_id, last_update) VALUES (:city, :countryId, :lastUpdate)", nativeQuery = true)
    void insertCity(@Param("city") String city, @Param("countryId") Long countryId, @Param("lastUpdate") java.sql.Timestamp lastUpdate);


}