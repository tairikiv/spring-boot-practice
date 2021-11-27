package com.example.springbootpractice.exceptions;

/**
 * Exception to handle unavailability of Teacher
 *
 * @author Tairi
 */
public class TeacherNotFoundException extends Exception {
    public TeacherNotFoundException(Long id){
        super("Teacher(id=" + id + ") not found");
    }
}
