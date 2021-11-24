package com.example.springbootpractice.models;

import lombok.Data;

import javax.persistence.*;

/**
 * City model
 *
 * @author Tairi
 */
@Data
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

}
