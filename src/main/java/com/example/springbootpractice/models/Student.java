package com.example.springbootpractice.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Student model
 *
 * @author Tairi
 */
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;

    @OneToOne
    private City city;
    @Enumerated(EnumType.STRING)
    private School school;


    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate joinDate;

    private boolean isActive;
}
