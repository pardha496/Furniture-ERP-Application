package com.funrierp.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GoblanExceptionHandler {
	
	@ExceptionHandler(NoProductFoundException.class)
	public ResponseEntity<String> productNotFound(NoProductFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {

        Map<String,List<String>> errors= new HashMap<>();
        List<String> errorList=new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
        	String errorName= error.getDefaultMessage();
        	errorList.add(errorName);
        });
        errors.put("List of errors", errorList);

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGenericException(Exception ex) {
	    Map<String, String> error = new HashMap<>();
	    error.put("error", ex.getMessage());
	    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
