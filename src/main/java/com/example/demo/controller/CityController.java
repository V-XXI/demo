package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.City;
import com.example.demo.repository.CityRepository;
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
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Operation(summary = "Get all cities", description = "Retrieve a list of all cities")
    @GetMapping("/getCities")
    public List<City> getAllCities() {
        try {
            return cityRepository.findAll();
        } catch (DataAccessException e) {
            throw new RuntimeException("An error occurred while getting all cities" + e.getMessage(), e);
        }
    }

    @Operation(summary = "Get cities by city ID (using query)", description = "Retrieve a list of cities by city ID using query")
    @GetMapping("/{cityId}")
    public List<City> getCitiesByCountryIdNative(@PathVariable Long cityId) {
          try {
        List<City> cities = cityRepository.findByCityIdNative(cityId);
        if (cities.isEmpty()) {
            throw new NotFoundException("City with ID " + cityId + " not found");
        }
        return cities;
    } catch (DataAccessException e) {
        throw new RuntimeException("An error occurred while getting a city by id: " + e.getMessage(), e);
    }

    }

    @Operation(summary = "Add a new city", description = "Add a new city to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "City added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/postCities")
    public String addCity(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "City object to be added to the database",
                    required = true,
                    content = @io.swagger.v3.oas.annotations.media.Content(
                            schema = @Schema(implementation = City.class)
                    )
            )
            @RequestBody City city) {
                try {
                    // Tentativo di inserimento del paese
                    cityRepository.insertCity(city.getCity(), city.getCountryId(), new Timestamp(System.currentTimeMillis()));
                    return "Country added successfully";
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException("Invalid timestamp format: " + e.getMessage(), e);
                } catch (DataAccessException e) {
                    throw new RuntimeException("Error adding city " + e.getMessage(), e);
                }
           
        }
    
         
        
    }