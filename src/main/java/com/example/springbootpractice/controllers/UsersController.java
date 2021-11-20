package com.example.springbootpractice.controllers;

import com.example.springbootpractice.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to handle all user related requests
 *
 * @author Tairi
 */
@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping
    public String showListUserPage(Model model) {
        model.addAttribute("users", usersService.getAllUsers());
        return "user/list-users";
    }
}
