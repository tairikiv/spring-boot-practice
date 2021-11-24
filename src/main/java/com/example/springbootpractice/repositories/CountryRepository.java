package com.example.springbootpractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to handle DB related Country operations
 *
 * @author Tairi
 */
public interface CountryRepository extends JpaRepository<Country, Long> {
}
