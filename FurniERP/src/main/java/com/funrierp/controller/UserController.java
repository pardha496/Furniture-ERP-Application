package com.funrierp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.funrierp.dto.LoginRequestDTO;
import com.funrierp.dto.UserRequestDTO;
import com.funrierp.dto.UserResponseDTO;
import com.funrierp.service.UserService;
import com.funrierp.utils.MessageResponse;
import com.funrierp.validator.ValidateUser;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	ValidateUser userValidation;
	
	
	@Autowired
	UserService userSerice;
	
	@PostMapping("signup")
	public ResponseEntity<?> userRegistration( @RequestBody @Valid UserRequestDTO userDetails){
		
		if(userValidation.existsByUsername(userDetails.getUsername()))
			return ResponseEntity
					.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		
		if(userValidation.existsByMail(userDetails.getEmail()))
			return ResponseEntity
					.badRequest().body(new MessageResponse("Error: Mail Id is already taken!"));
		
		userSerice.saveUser(userDetails);
		//return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		
		return new ResponseEntity<String>("User "+ userDetails.getUsername() +" registered successfully!", HttpStatus.CREATED);
	}
	
	@PostMapping("signin")
	public ResponseEntity<?> signin( @RequestBody @Valid LoginRequestDTO userDetails){
		
		return new ResponseEntity<String>(userValidation.verify(userDetails), HttpStatus.OK);
	}
	
	@GetMapping("getAllemployees")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllEmployees() {
		//TODO: process POST request
		
		return new ResponseEntity<List<UserResponseDTO>>(userSerice.getAllEmployees(), HttpStatus.OK);
	}
	

}
