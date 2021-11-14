package com.example.springbootpractice.models;

import lombok.Data;

/**
 * Login model for security
 *
 * @author Tairi
 */
@Data
public class Login {
    private String username;
    private String password;

}
