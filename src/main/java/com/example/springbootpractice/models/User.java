package com.example.springbootpractice.models;

import lombok.Data;

import javax.persistence.*;

/**
 * User model for security
 *
 * @author Tairi
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;

    @OneToOne(cascade = CascadeType.MERGE)
    private Authority authority;
}
