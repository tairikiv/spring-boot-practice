package com.example.springbootpractice.controllers;

import com.example.springbootpractice.models.City;
import com.example.springbootpractice.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    public List<City> getAllCities(){
        return cityService.findAllCities();
    }
}

