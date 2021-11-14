package com.example.springbootpractice.services;

import com.example.springbootpractice.models.User;

import java.util.List;
import java.util.Optional;

/**
 * Service to handle User related operations
 *
 * @author Tairi
 */
public interface UserService {
    /**
     * To create a new user
     * @param user User
     */
    void createUser(User user);

    /**
     * To find user by username
     * @param username User's username
     * @return Optional of user
     */
    Optional<User> findUserByUsername(String username);

    /**
     * To find user by username and password
     * @param username User's username
     * @param password User's password
     * @return Optional of User
     */
    Optional<User> findUserByUsernameAndPassword(String username, String password);

    /**
     * To get all the users
     * @return List of User
     */
    List<User> getAllUsers();
}
