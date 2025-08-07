package com.funrierp.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.funrierp.repository.UserRepo;

@Component
public class ValidateUser {

	@Autowired
	UserRepo userRespo;
	
	public boolean existsByUsername(String username) {
		if(userRespo.findByUsername(username).isPresent()) 
			return true;
		return false;
	}

	public boolean existsByMail(String mail) {
		if(userRespo.existsByEmail(mail)) 
			return true;
		return false;
	}

}
