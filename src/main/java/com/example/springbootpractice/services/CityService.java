package com.example.springbootpractice.services;

import com.example.springbootpractice.models.City;

import java.util.List;

/**
 * Service to handle City related operations
 *
 * @author Tairi
 */
public interface CityService {

    /**
     * To find all cities
     *
     * @return List of City
     */
    List<City> findAllCities();
}
