package com.example.springbootpractice.services;

import com.example.springbootpractice.models.City;

import java.util.List;
import java.util.Optional;

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

    /**
     * To create a new city
     * @param city City
     */
    void createCity(City city);

    /**
     * to find a city by its name
     * @param name Name of the city
     * @return Optional of City
     */
    Optional<City> findCityByName(String name);
}
