package com.example.springbootpractice.services;

import com.example.springbootpractice.models.City;
import com.example.springbootpractice.models.Person;

import java.util.List;

/**
 * Service to handle person related operations
 *
 * @author Tairi
 */
public interface PersonService {

    /**
     * To find all persons
     * @return List of persons
     */
    List<Person> findAllPersons();


    List<Person> findAllPersonsByCity(City city);
}
