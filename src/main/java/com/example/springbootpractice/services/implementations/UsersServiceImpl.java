package com.example.springbootpractice.services.implementations;

import com.example.springbootpractice.models.Users;
import com.example.springbootpractice.repositories.UsersRepository;
import com.example.springbootpractice.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of UserService
 *
 * @author Tairi
 */
@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void createUser(Users users) {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        usersRepository.save(users);
    }

    @Override
    public Optional<Users> findUserByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public Optional<Users> findUserByUsernameAndPassword(String username, String password) {
        return usersRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
}
