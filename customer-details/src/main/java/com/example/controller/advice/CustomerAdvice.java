package com.example.controller.advice;

import com.example.exception.CustomerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerAdvice extends Exception {

  @ExceptionHandler(CustomerException.class)
    public ResponseEntity<String> handleCustomerException(CustomerException c) {
      String message = c.getCode() + " " + c.getMessage();
      return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
  }
      @ExceptionHandler(Exception.class)
      public ResponseEntity handleStudentException(){
          return new ResponseEntity("internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
