package com.example.springbootpractice.handlers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Model for error response
 *
 * @author Tairi
 */
@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private List<String> details;
}
