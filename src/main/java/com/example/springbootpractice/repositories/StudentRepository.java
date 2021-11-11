package com.example.springbootpractice.repositories;

import com.example.springbootpractice.models.City;
import com.example.springbootpractice.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to handle DB operations for Student
 *
 * @author Tairi
 */
 @Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
     List<Student> findAllByCity(City city);
}
