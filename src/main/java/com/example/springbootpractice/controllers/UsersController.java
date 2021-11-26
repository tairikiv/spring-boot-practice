package com.example.springbootpractice.controllers;

import com.example.springbootpractice.models.City;
import com.example.springbootpractice.models.School;
import com.example.springbootpractice.models.Specialization;
import com.example.springbootpractice.models.Users;
import com.example.springbootpractice.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/update/{id}")
    public String updateUsersForm(@PathVariable("id") Long id, @RequestParam(value="users", required=false) Users users,
                                    @ModelAttribute("messageType") String messageType, @ModelAttribute("message") String message,
                                    Model model, RedirectAttributes redirectAttributes) {
        if (users == null) {
            Optional<Users> usersOptional = usersService.findUsersById(id);
            if (usersOptional.isPresent()) {
                model.addAttribute("users", usersOptional.get());
            } else {
                redirectAttributes.addFlashAttribute("messageType", "error");
                redirectAttributes.addFlashAttribute("message", "The user (id=" + id + ") is not found!");
                return "redirect:/users";
            }
        }
        model.addAttribute("authorities", users.getAuthority());
        return "user/update-users";
    }

    @PostMapping("/update/{id}")
    public String updateUsers(@PathVariable("id") Long id,  Users users, RedirectAttributes redirectAttributes) {
        try {
            users.setId(id);
            usersService.updateUsers(users);
            redirectAttributes.addFlashAttribute("messageType", "success");
            redirectAttributes.addFlashAttribute("message", "A user has been updated successfully!");
            return "redirect:/users";
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            redirectAttributes.addFlashAttribute("users", users);
            redirectAttributes.addFlashAttribute("messageType", "error");
            redirectAttributes.addFlashAttribute("message", "Error in updating a user!");
            return "redirect:/users/update";
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteUsers(@PathVariable("id") Long id, RedirectAttributes redirectAttributes ){
        try{
            usersService.deleteUsersById(id);
            redirectAttributes.addFlashAttribute("messageType", "success");
            redirectAttributes.addFlashAttribute("message", "A user has been deleted successfully!");
            return "redirect:/users";
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            redirectAttributes.addFlashAttribute("messageType", "error");
            redirectAttributes.addFlashAttribute("message", "Error in deleting a user!");
            return "redirect:/users";
        }
    }
    @GetMapping("/restore/{id}")
    public String restoreUsers(@PathVariable("id") Long id, RedirectAttributes redirectAttributes ){
        try{
            usersService.restoreUsersById(id);
            redirectAttributes.addFlashAttribute("messageType", "success");
            redirectAttributes.addFlashAttribute("message", "A user has been restored successfully!");
            return "redirect:/users";
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            redirectAttributes.addFlashAttribute("messageType", "error");
            redirectAttributes.addFlashAttribute("message", "Error in restoring a user!");
            return "redirect:/users";
        }
    }
}
