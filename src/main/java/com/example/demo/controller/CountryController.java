package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;
import com.example.demo.exception.NotFoundException;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired CountryRepository countryRepository;

    // Other methods of the controller
    //add get method to get all countries

    @Operation (summary = "Get all countries", description = "Retrieve a list of all countries")
    @GetMapping("/getCountries")
    public List<Country> getAllCountries() {
        try {
            return countryRepository.findAll();
        } catch (DataAccessException e) {
            throw new RuntimeException("An error occurred while getting all countries" + e.getMessage(), e);
        }
    }

    //add get method to get country by id
    @GetMapping("/{countryId}")
    public List<Country> getCountryById(@PathVariable Long countryId) {
        try {
        List<Country> countries = countryRepository.findByCountryIdNative(countryId);
        System.out.println(countries);
        if (countries.isEmpty()) {
            throw new NotFoundException("Country with ID " + countryId + " not found");
        }
        return countries;
    } catch (DataAccessException e) {
        throw new RuntimeException("An error occurred while getting a country by id: " + e.getMessage(), e);
    }

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
            try {
                // Tentativo di inserimento del paese
                countryRepository.insertCountry(country.getCountry(), new Timestamp(System.currentTimeMillis()));
                return "Country added successfully";
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid timestamp format: " + e.getMessage(), e);
            } catch (DataAccessException e) {
                throw new RuntimeException("Error adding country: " + e.getMessage(), e);
            }
       
    }

     
    
}