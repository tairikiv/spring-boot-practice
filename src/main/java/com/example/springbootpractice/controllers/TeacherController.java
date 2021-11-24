package com.example.springbootpractice.controllers;

import com.example.springbootpractice.models.Teacher;
import com.example.springbootpractice.services.CityService;
import com.example.springbootpractice.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


/**
 * Controller to handle Teacher related web requests
 *
 * @author Tairi
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CityService cityService;

    @GetMapping("")
    public List<Teacher> getAllTeachers(){
        return  teacherService.findAllTeachers();
    }

    @PostMapping
    public ResponseEntity<?> addTeacher(@RequestBody Teacher teacher){
            teacherService.crateTeacher(teacher);
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher) {
        teacherService.updateTeacher(teacher);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(teacher, headers, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable("id") Long id) {
        teacherService.deleteTeacherById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreTeacher(@PathVariable("id") Long id) {
        teacherService.restoreTeacherById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
