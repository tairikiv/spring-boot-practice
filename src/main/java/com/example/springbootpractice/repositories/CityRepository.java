package com.example.springbootpractice.repositories;

import com.example.springbootpractice.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to handle DB related City operations
 *
 * @author Tairi
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
