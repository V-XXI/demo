package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired CountryRepository countryRepository;

    // Other methods of the controller
    //add get method to get all countries

    @Operation (summary = "Get all countries", description = "Retrieve a list of all countries")
    @GetMapping("/getCountries")
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    //add get method to get country by id
    @GetMapping("/country/{countryId}")
    public List<Country> getCountryById(@PathVariable Long countryId) {
        return countryRepository.findByCountryIdNative(countryId);
    }

    //add post method to insert country
    @PostMapping("/postCountries")
    public String addCountry(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Country object to be added to the database",
            required = true,
            content = @io.swagger.v3.oas.annotations.media.Content(
                schema = @Schema(implementation = Country.class)
            )
        )
        @RequestBody Country country) {
        countryRepository.insertCountry(country.getCountry(), new Timestamp(System.currentTimeMillis()));
        return "Country added successfully";
       
    }
    
}
