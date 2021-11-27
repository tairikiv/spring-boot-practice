package com.example.springbootpractice.handlers;

import com.example.springbootpractice.exceptions.TeacherNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Handler for exceptions
 *
 * @author Tairi
 */
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse errorResponse = new ErrorResponse("Server Error!", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TeacherNotFoundException.class)
    public final ResponseEntity<Object> handleTeacherNotFoundException(Exception ex){
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse errorResponse = new ErrorResponse("Request Error!", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest webRequest) {
        List<String> details = new ArrayList<>();

        for (ObjectError objectError: ex.getBindingResult().getAllErrors()){
            details.add(objectError.getDefaultMessage());
        }

        ErrorResponse errorResponse = new ErrorResponse("Validation failed!", details);
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
