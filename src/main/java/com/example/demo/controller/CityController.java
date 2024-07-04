package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.repository.CityRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Operation(summary = "Get all cities", description = "Retrieve a list of all cities")
    @GetMapping("/getCities")
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Operation(summary = "Add a new city", description = "Add a new city to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "City added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/postCities")
    public City addCity(@RequestBody City city) {
        return cityRepository.save(city);
    }

    // Other methods of the controller
}
