package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.repository.CityRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
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
        return cityRepository.findAll();
    }

    @Operation(summary = "Get cities by country ID (using query)", description = "Retrieve a list of cities by country ID using query")
    @GetMapping("/country/native/{countryId}")
    public List<City> getCitiesByCountryIdNative(@PathVariable Long countryId) {
        return cityRepository.findByCountryIdNative(countryId);
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

        cityRepository.insertCity(city.getCity(), city.getCountryId(), new Timestamp(System.currentTimeMillis()));
        return "City added successfully";
    }

    // Altri metodi del controller
}