package com.example.springbootpractice.services;

import com.example.springbootpractice.models.City;
import com.example.springbootpractice.models.Teacher;

import java.util.List;
import java.util.Optional;

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

    /**
     * TO find teacher by id
     * @param id Id of the teacher
     * @return Optional of teacher
     */
    Optional<Teacher> findTeacherById(Long id);

    /**
     * To update a teacher
     * @param teacher Teacher
     */
    void updateTeacher(Teacher teacher);

    /**
     * To delete a teacher by Id
     * @param id Id of the teacher
     */
    void deleteTeacherById(Long id);

    /**
     * To restore teacher by Id
     * @param id Id of the teacher
     */
    void restoreTeacherById(Long id);
}
