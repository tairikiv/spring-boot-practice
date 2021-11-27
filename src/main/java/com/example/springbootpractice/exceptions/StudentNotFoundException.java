package com.example.springbootpractice.exceptions;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(Long id) {
        super("Student(id=" + id + ") not found!");
    }
}
