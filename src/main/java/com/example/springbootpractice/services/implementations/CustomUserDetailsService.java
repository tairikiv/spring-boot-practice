package com.example.springbootpractice.services.implementations;

import com.example.springbootpractice.models.User;
import com.example.springbootpractice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Customized implementation of UserDetailsService
 *
 * @author Tairi
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
   @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optionalUser = userService.findUserByUsername(s);

        if(!optionalUser.isPresent()){
            throw new UsernameNotFoundException("User not found with username: " + s);
        }
        return new CustomUserDetails(optionalUser.get());
    }
}
