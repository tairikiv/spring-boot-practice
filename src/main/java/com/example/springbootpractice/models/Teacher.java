package com.example.springbootpractice.models;

import com.example.springbootpractice.utils.validation.ValidCity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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

    @NotBlank(message = "{messages.constraints.empty-first-name}" )
    private String firstName;

    @NotBlank(message = "{messages.constraints.empty-last-name}")
    private String lastName;

    @Min(value = 21, message = "{messages.constraints.min-age-invalid}")
    @Max(value = 60, message = "{messages.constraints.max-age-invalid}")
    private int age;

    @ValidCity
    @OneToOne(cascade = CascadeType.MERGE)
    private City city;

    @Enumerated(EnumType.STRING)
    private School school;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate joinDate;

    private boolean isActive;
}
