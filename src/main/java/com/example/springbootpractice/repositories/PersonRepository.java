package com.example.springbootpractice.repositories;

import com.example.springbootpractice.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to handle DB operations for Person
 *
 * @author Tairi
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
