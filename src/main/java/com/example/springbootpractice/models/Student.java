package com.example.springbootpractice.models;

import com.example.springbootpractice.utils.validation.ValidCity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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

    @NotBlank(message = "{messages.constraints.empty-first-name}")
    private String firstName;

    @NotBlank(message = "{messages.constraints.empty-last-name}")
    private String lastName;

    @Min(value = 15, message = "{messages.constraints.student.min-age-invalid}")
    private int age;

    @ValidCity
    @OneToOne(cascade = CascadeType.MERGE)
    private City city;

    @Enumerated(EnumType.STRING)
    private School school;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate joinDate;

    private boolean isActive;
}
