package com.example.springbootpractice.configuration;

import com.example.springbootpractice.models.*;
import com.example.springbootpractice.services.CityService;
import com.example.springbootpractice.services.StudentService;
import com.example.springbootpractice.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

/**
 * To initialize the data
 *
 * @author Tairi
 */
@Component
public class DataInit {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CityService cityService;
    @Autowired
    private StudentService studentService;

    @PostConstruct
    public void init(){
        initCity();
        initTeacher();
        initStudent();
    }

    private void initCity(){
        if(cityService.findAllCities().isEmpty()){
            City city = new City();
            city.setName("Tallinn");
            cityService.createCity(city);

            City city1 = new City();
            city1.setName("Tartu");
            cityService.createCity(city1);
        }
    }

    private void initTeacher(){
        if(teacherService.findAllTeachers().isEmpty()){
            Teacher teacher = new Teacher();
            teacher.setFirstName("Vinod");
            teacher.setLastName("John");
            teacher.setAge(20);
            teacher.setSchool(School.TALLINN_UNIVERSITY);
            teacher.setSpecialization(Specialization.SOFTWARE);
            cityService.findCityByName("Tallinn").ifPresent(teacher::setCity);
            teacher.setJoinDate(LocalDate.of(2021, 10, 30));
            teacherService.crateTeacher(teacher);
        }
    }
    private void initStudent(){
        if(studentService.findAllStudents().isEmpty()){
            Student student = new Student();
            student.setFirstName("Mari");
            student.setLastName("Rebane");
            student.setAge(20);
            student.setSchool(School.TTU);
            cityService.findCityByName("Tartu").ifPresent(student::setCity);
            student.setJoinDate(LocalDate.of(2021, 11, 8));
            studentService.crateStudent(student);
        }
    }
}
