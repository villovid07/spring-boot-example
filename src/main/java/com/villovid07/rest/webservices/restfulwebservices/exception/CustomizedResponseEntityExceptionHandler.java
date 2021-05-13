/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.villovid07.rest.webservices.restfulwebservices.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author villovid07
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler 
        extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        ExceptionResponse excepctionResponse = new ExceptionResponse(new Date(),ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(excepctionResponse,HttpStatus.INTERNAL_SERVER_ERROR);    
    }
    
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
        ExceptionResponse excepctionResponse = new ExceptionResponse(new Date(),ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(excepctionResponse,HttpStatus.NOT_FOUND);
    }
   
}
