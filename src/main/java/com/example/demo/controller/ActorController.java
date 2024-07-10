package com.example.demo.controller;

import com.example.demo.model.Actor;
import com.example.demo.model.City;
import com.example.demo.repository.ActorRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
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
        return actorRepository.findAll();
    }

    @Operation(summary = "Add a new actor", description = "Add a new Actor to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Actor added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/postAxtors")
    public String addActor(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Actor object to be added to the database",
                    required = true,
                    content = @io.swagger.v3.oas.annotations.media.Content(
                            schema = @Schema(implementation = Actor.class)
                    )
            )
            @RequestBody Actor actor) {

        actorRepository.insertActor(actor.getFirst_name(), actor.getLast_name(), new Timestamp(System.currentTimeMillis()));
        return "Actor added successfully";
    }
    // Other methods of the controller
}
