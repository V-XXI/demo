package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import com.example.demo.model.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long>{ //le proprietà della classe city sono le stesse del DB, le possiamo prendere come sono e modificarle

//add query sql to f in all actor
@Query(value = "SELECT * FROM actor", nativeQuery = true) //per operare sulla query
List<Actor> findAll();

//add query sql to f ind city by id
@Query(value = "SELECT * FROM actor WHERE actor = ?1", nativeQuery = true) 
List<Actor> findByActorIdNative(Long actorId); //copiare in 

//add query sql to insert city
@Modifying
@Transactional
@Query(value = "INSERT INTO actor (first_name, last_name, last_update) VALUES (:first_name, :last_name, :last_update)", nativeQuery = true)
void insertActor(@Param("first_name") String first_name, @Param ("last_name") String last_name, @Param("last_update") java.sql.Timestamp last_update);

}