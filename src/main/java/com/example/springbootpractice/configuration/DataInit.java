package com.example.springbootpractice.configuration;

import com.example.springbootpractice.models.*;
import com.example.springbootpractice.services.*;
import com.example.springbootpractice.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Optional;

/**
 * To initialize the data
 *
 * @author Tairi
 */
@Component
public class DataInit {
    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CityService cityService;

    @Autowired
    private StudentService studentService;

    @PostConstruct
    public void init(){
        initAuthority();
        initUser();
        initCity();
        initTeacher();
        initStudent();
    }

    // PRIVATE METHODS //
    private  void initAuthority() {
    Authority authorityAdmin = new Authority();
    authorityAdmin.setName(Constants.Security.AUTHORITY_ADMIN);
    authorityService.createAuthority(authorityAdmin);

    Authority authorityTeacher = new Authority();
    authorityTeacher.setName(Constants.Security.AUTHORITY_TEACHER);
    authorityService.createAuthority(authorityTeacher);

    Authority authorityStudent = new Authority();
    authorityStudent.setName(Constants.Security.AUTHORITY_STUDENT);
    authorityService.createAuthority(authorityStudent);
    }

    private void initUser() {
        Optional<Authority> optionalAuthority = authorityService.findAuthorityByName(Constants.Security.AUTHORITY_ADMIN);

        if(optionalAuthority.isPresent()) {
            Users users = new Users();
            users.setUsername("admin_sda@gmail.com");
            users.setPassword("123456");
            users.setAuthority(optionalAuthority.get());

            if(!usersService.findUserByUsername(users.getUsername()).isPresent()) {
                usersService.createUser(users);
            }
        }
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
