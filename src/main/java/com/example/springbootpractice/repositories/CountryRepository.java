package com.example.springbootpractice.repositories;

import com.example.springbootpractice.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to handle DB related Country operations
 *
 * @author Tairi
 */
public interface CountryRepository extends JpaRepository<Country, Long> {
}
