package com.example.springbootpractice.services;

import com.example.springbootpractice.models.Users;

import java.util.List;
import java.util.Optional;

/**
 * Service to handle User related operations
 *
 * @author Tairi
 */
public interface UsersService {
    /**
     * To create a new user
     * @param users User
     */
    void createUser(Users users);

    /**
     * To find user by username
     * @param username User's username
     * @return Optional of user
     */
    Optional<Users> findUserByUsername(String username);

    /**
     * To find user by username and password
     * @param username User's username
     * @param password User's password
     * @return Optional of User
     */
    Optional<Users> findUserByUsernameAndPassword(String username, String password);

    /**
     * To get all the users
     * @return List of User
     */
    List<Users> getAllUsers();
}
