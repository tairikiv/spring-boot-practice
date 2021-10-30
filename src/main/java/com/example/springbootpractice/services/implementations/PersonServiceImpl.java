package com.example.springbootpractice.services.implementations;

import com.example.springbootpractice.models.Person;
import com.example.springbootpractice.repositories.PersonRepository;
import com.example.springbootpractice.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
   @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }
}
