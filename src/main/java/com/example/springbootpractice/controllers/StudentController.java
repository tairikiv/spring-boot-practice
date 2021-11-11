package com.example.springbootpractice.controllers;

import com.example.springbootpractice.models.Student;
import com.example.springbootpractice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public String showAllStudents(Model model){
        List<Student> students = studentService.findAllStudents();
        model.addAttribute("students", students );
        return "student/list-students";
    }
}
