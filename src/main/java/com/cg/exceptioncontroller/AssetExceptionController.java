package com.cg.exceptioncontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.exception.AssetNotFoundException;


@ControllerAdvice
public class AssetExceptionController {
	
@ExceptionHandler(value = AssetNotFoundException.class)
    
    public ResponseEntity<Object> handleUserException(Exception ex){
        return new ResponseEntity<Object>("Asset Not Found",HttpStatus.NOT_FOUND);
    }
	

}
