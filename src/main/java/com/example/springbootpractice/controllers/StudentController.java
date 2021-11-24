package com.example.springbootpractice.controllers;

import com.example.springbootpractice.models.*;
import com.example.springbootpractice.services.CityService;
import com.example.springbootpractice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CityService cityService;

    @GetMapping("")
    public List<Student> showAllStudents( ){
        return studentService.findAllStudents();
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        studentService.crateStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(student, headers, HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreStudent(@PathVariable("id") Long id ){
        studentService.restoreStudentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
