package com.example.springbootpractice.services;

import com.example.springbootpractice.models.City;
import com.example.springbootpractice.models.Student;
import com.example.springbootpractice.models.Teacher;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAllStudents();

    List<Student> findAllStudentsByCity(City city);

    void crateStudent(Student student);

    Optional<Student> findStudentById(Long id);

    void updateStudent(Student student);

    void deleteStudentById(Long id);

    void restoreStudentById(Long id);
}
