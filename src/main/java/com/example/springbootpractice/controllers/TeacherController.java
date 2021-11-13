package com.example.springbootpractice.controllers;

import com.example.springbootpractice.models.Teacher;
import com.example.springbootpractice.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Controller to handle Teacher related web requests
 *
 * @author Tairi
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("")
    public String showAllTeachers(Model model){
        List<Teacher> teachers = teacherService.findAllTeachers();
        model.addAttribute("teachers", teachers );
        return "teacher/list-teachers";
    }

}
