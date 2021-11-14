package com.example.springbootpractice.controllers;

import com.example.springbootpractice.models.*;
import com.example.springbootpractice.services.CityService;
import com.example.springbootpractice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CityService cityService;

    @GetMapping("")
    public String showAllStudents(Model model, @ModelAttribute("messageType") String messageType,
                                  @ModelAttribute("message") String message){
        List<Student> students = studentService.findAllStudents();
        model.addAttribute("students", students );
        return "student/list-students";
    }

    @GetMapping("/add")
    public String addStudentForm(@ModelAttribute("student") Student student, Model model, @ModelAttribute("messageType") String messageType,
                                 @ModelAttribute("message") String message){
        List<City> cities = cityService.findAllCities();
        model.addAttribute("cities", cities);
        model.addAttribute("schools", School.values());
        return "student/add-student";
    }
    @PostMapping("/add")
    public String addStudent(Student student, RedirectAttributes redirectAttributes){
        try {
            studentService.crateStudent(student);
            redirectAttributes.addFlashAttribute("messageType", "success");
            redirectAttributes.addFlashAttribute("message", "A student has been created successfully!");
            return "redirect:/student";
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            redirectAttributes.addFlashAttribute("student", student);
            redirectAttributes.addFlashAttribute("messageType", "error");
            redirectAttributes.addFlashAttribute("message", "Error in adding a student!");
            return "redirect:/student/add";
        }
    }
    @GetMapping("/update/{id}")
    public String updateStudentForm(@PathVariable("id") Long id, @RequestParam(value="student", required=false) Student student,
                                    @ModelAttribute("messageType") String messageType, @ModelAttribute("message") String message,
                                    Model model, RedirectAttributes redirectAttributes) {
        if(student == null){
            Optional<Student> studentOptional = studentService.findStudentById(id);
            if(studentOptional.isPresent()){
                model.addAttribute("student", studentOptional.get());
            } else {
                redirectAttributes.addFlashAttribute("messageType", "error");
                redirectAttributes.addFlashAttribute("message", "The student (id=" +id + ") is not found!");
                return "redirect:/student";
            }
        }
        List<City> cities = cityService.findAllCities();
        model.addAttribute("cities", cities);
        model.addAttribute("schools", School.values());
        return "student/update-student";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long id,  Student student, RedirectAttributes redirectAttributes) {
        try {
            student.setId(id);
            studentService.updateStudent(student);
            redirectAttributes.addFlashAttribute("messageType", "success");
            redirectAttributes.addFlashAttribute("message", "A student has been updated successfully!");
            return "redirect:/student";
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            redirectAttributes.addFlashAttribute("student", student);
            redirectAttributes.addFlashAttribute("messageType", "error");
            redirectAttributes.addFlashAttribute("message", "Error in updating a student!");
            return "redirect:/student/update";
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, RedirectAttributes redirectAttributes ){
        try{
            studentService.deleteStudentById(id);
            redirectAttributes.addFlashAttribute("messageType", "success");
            redirectAttributes.addFlashAttribute("message", "A student has been deleted successfully!");
            return "redirect:/student";
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            redirectAttributes.addFlashAttribute("messageType", "error");
            redirectAttributes.addFlashAttribute("message", "Error in deleting a student!");
            return "redirect:/student";
        }
    }
    @GetMapping("/restore/{id}")
    public String restoreStudent(@PathVariable("id") Long id, RedirectAttributes redirectAttributes ){
        try{
            studentService.restoreStudentById(id);
            redirectAttributes.addFlashAttribute("messageType", "success");
            redirectAttributes.addFlashAttribute("message", "A student has been restored successfully!");
            return "redirect:/student";
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            redirectAttributes.addFlashAttribute("messageType", "error");
            redirectAttributes.addFlashAttribute("message", "Error in restoring a student!");
            return "redirect:/student";
        }
    }
}
