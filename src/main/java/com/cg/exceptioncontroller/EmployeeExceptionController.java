package com.cg.exceptioncontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.exception.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeExceptionController {
	
	@ExceptionHandler(value = EmployeeNotFoundException.class)
    
    public ResponseEntity<Object> handleUserException(Exception ex){
        return new ResponseEntity<Object>("Employee Not Found",HttpStatus.NOT_FOUND);
    }
	

}
