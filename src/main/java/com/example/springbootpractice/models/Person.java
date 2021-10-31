package com.example.springbootpractice.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Person model
 *
 * @author Tairi
 */
@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;

    @OneToOne
    private City city;

}
