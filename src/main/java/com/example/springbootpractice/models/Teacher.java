package com.example.springbootpractice.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Teacher model
 *
 * @author Tairi
 */
@Data
@Entity
public class Teacher{
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

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    private LocalDate joinDate;
}
