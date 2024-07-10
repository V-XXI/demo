package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Actor;
import com.example.demo.model.Actor;
import com.example.demo.repository.ActorRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("api/") //operazioni per gli attori

public class ActorController {
    
    @Autowired
    private ActorRepository actorRepository;

    @Operation(summary = "Get all actors", description = "Retrieve a list of all actors")
    @GetMapping("actors")
    public List<Actor> getAllactors() {
           try {
            return actorRepository.findAll();
        } catch (DataAccessException e) {
            throw new RuntimeException("An error occurred while getting all actors" + e.getMessage(), e);
        }
    }

    @Operation(summary = "Add a new actor", description = "Add a new Actor to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Actor added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    //add get method to get country by id
    @GetMapping("/{actor_id}")
    public List<Actor> getCountryById(@PathVariable Long actor_id) {
        try {
        List<Actor> actors = actorRepository.findByActorIdNative(actor_id);
        System.out.println(actors);
        if (actors.isEmpty()) {
            throw new NotFoundException("Actor with ID " + actor_id + " not found");
        }
        return actors;
    } catch (DataAccessException e) {
        throw new RuntimeException("An error occurred while getting a country by id: " + e.getMessage(), e);
    }

    }

    @PostMapping("/postActors")
    public String addActor(
                    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Actor object to be added to the database", required = true, content = @io.swagger.v3.oas.annotations.media.Content(schema = @Schema(implementation = Actor.class))) @RequestBody Actor actor) {
                try {
                    // Tentativo di inserimento dell'attore
                    actorRepository.insertActor(actor.getFirst_name(), actor.getLast_name(), new Timestamp(System.currentTimeMillis()));
                    return "actor added successfully";
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException("Invalid timestamp format: " + e.getMessage(), e);
                } catch (DataAccessException e) {
                    throw new RuntimeException("Error adding actor: " + e.getMessage(), e);
                }

    }

    // Other methods of the controller
}