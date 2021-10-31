package com.example.springbootpractice.repositories;

import com.example.springbootpractice.models.City;
import com.example.springbootpractice.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to handle DB operations for Person
 *
 * @author Tairi
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAllByCity(City city);

}
