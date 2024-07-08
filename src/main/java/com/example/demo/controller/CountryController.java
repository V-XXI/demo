package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;

public class CountryController {

    @Autowired CountryRepository countryRepository;

    // Other methods of the controller
    //add get method to get all countries

    @GetMapping("/getCountries")
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
    
}
