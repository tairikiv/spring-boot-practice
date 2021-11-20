package com.example.springbootpractice.repositories;

import com.example.springbootpractice.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository to handle DB operations for user
 *
 * @author Tairi
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);

    Optional<Users> findByUsernameAndPassword(String username, String password);
}
