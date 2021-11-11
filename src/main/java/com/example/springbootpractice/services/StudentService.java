package com.example.springbootpractice.services;

import com.example.springbootpractice.models.City;
import com.example.springbootpractice.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAllStudents();

    List<Student> findAllStudentsByCity(City city);

    void crateStudent(Student student);
}
