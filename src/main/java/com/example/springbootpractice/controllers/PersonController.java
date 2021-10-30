package com.example.springbootpractice.controllers;

import com.example.springbootpractice.models.Person;
import com.example.springbootpractice.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Controller to handle Person related web requests
 *
 * @author Tairi
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    public List<Person> getAllPersons(){
        return personService.findAllPersons();
    }
}
