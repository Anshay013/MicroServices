package com.sasuke.user.service.UserService.exceptions;

import com.sasuke.user.service.UserService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
/* It is a specialized version of @ControllerAdvice in Spring Boot, used for centralized exception handling
and global processing of REST controllers. It works with @ExceptionHandler, @ModelAttribute, and @InitBinder methods, but it's
specifically designed for @RestController components.*/

// where exception comes in this project, the class annotated with @RestControllerAdvice will be called to handle it via the implementation wrote inside it.

public class GlobalExceptionHandler {

    // methods inside this class behaves like a catch statement

    @ExceptionHandler(ResourceNotFoundException.class) // in the whole project wherever the exception from ResourceNotFoundException class is generated
    // the below method will be called.
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {

         ApiResponse response = ApiResponse.builder()
                                           .message(ex.getMessage())
                                           .success(true) // obviously its a not found but the success is true
                                           .status(HttpStatus.NOT_FOUND) // didn't get the resource
                                           .build();

         // lombok builder wasn't working so defined the whole builder pattern

         return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);

    }
}
