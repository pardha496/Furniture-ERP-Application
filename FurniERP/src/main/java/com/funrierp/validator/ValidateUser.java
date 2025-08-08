package com.funrierp.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.funrierp.dto.LoginRequestDTO;
import com.funrierp.repository.UserRepo;
import com.funrierp.security.JWTService;

@Component
public class ValidateUser {

	@Autowired
	UserRepo userRespo;
	
	@Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;
    
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
	
	public String verify(LoginRequestDTO user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        } else {
            return "fail";
        }
    }

}
