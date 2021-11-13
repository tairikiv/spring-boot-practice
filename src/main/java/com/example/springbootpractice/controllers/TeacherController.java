package com.example.springbootpractice.controllers;

import com.example.springbootpractice.models.City;
import com.example.springbootpractice.models.School;
import com.example.springbootpractice.models.Specialization;
import com.example.springbootpractice.models.Teacher;
import com.example.springbootpractice.services.CityService;
import com.example.springbootpractice.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private CityService cityService;

    @GetMapping("")
    public String showAllTeachers(Model model){
        List<Teacher> teachers = teacherService.findAllTeachers();
        model.addAttribute("teachers", teachers );
        return "teacher/list-teachers";
    }

    @GetMapping("/add")
    public String addTeacherForm(@ModelAttribute("teacher") Teacher teacher, Model model){
        List<City> cities = cityService.findAllCities();
        model.addAttribute("cities", cities);
        model.addAttribute("schools", School.values());
        model.addAttribute("specializations", Specialization.values());

        return "teacher/add-teacher";
    }

    @PostMapping("/add")
    public String addTeacher(Teacher teacher){
        teacherService.crateTeacher(teacher);
        return "redirect:/teacher";
    }
}
