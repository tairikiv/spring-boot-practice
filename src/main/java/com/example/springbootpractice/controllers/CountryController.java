package com.example.springbootpractice.controllers;

import com.example.springbootpractice.models.Country;
import com.example.springbootpractice.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;

    public List<Country> getAllCountries(){
        return countryService.findAllCountries();
    }
}
