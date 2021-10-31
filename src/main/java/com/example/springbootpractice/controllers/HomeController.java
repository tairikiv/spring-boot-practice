package com.example.springbootpractice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for Home page
 *
 * @author Tairi
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("")
    public String showHomePage(){
        return "home";
    }
}
