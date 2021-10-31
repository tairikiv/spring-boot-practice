package com.example.springbootpractice.repositories;

import com.example.springbootpractice.models.City;
import com.example.springbootpractice.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to handle DB operations for Teacher
 *
 * @author Tairi
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllByCity(City city);

}
