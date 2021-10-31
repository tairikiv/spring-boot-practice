package com.example.springbootpractice.configuration;

import com.example.springbootpractice.models.City;
import com.example.springbootpractice.models.School;
import com.example.springbootpractice.models.Specialization;
import com.example.springbootpractice.models.Teacher;
import com.example.springbootpractice.services.CityService;
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

    @PostConstruct
    public void init(){
        initCity();
        initTeacher();
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
}
