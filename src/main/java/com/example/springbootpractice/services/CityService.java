package com.example.springbootpractice.services;

import com.example.springbootpractice.models.City;

import java.util.List;

public interface CityService {

    List<City> findAllCities();
}
