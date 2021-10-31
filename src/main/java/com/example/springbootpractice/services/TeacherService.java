package com.example.springbootpractice.services;

import com.example.springbootpractice.models.City;
import com.example.springbootpractice.models.Teacher;

import java.util.List;

/**
 * Service to handle teacher related operations
 *
 * @author Tairi
 */
public interface TeacherService {

    /**
     * To find all teachers
     * @return List of teachers
     */
    List<Teacher> findAllTeachers();


    List<Teacher> findAllTeachersByCity(City city);

    /**
     * To create new teacher
     * @param teacher Teacher
     */
    void crateTeacher(Teacher teacher);

}
