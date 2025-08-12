package com.funrierp.mapper;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.funrierp.dto.LoginResponseDTO;
import com.funrierp.dto.UserRequestDTO;
import com.funrierp.dto.UserResponseDTO;
import com.funrierp.entity.User;

import lombok.Data;

@Data
public class UserMapper {
	
	@Autowired
	static private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
    public static User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        // password encryption
        user.setActive(true);
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setCreatedDate(new Date());
        
        return user;
    }

    public static LoginResponseDTO toLoginResponse(User user, String token) {
        LoginResponseDTO dto = new LoginResponseDTO();
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole());
        dto.setToken(token);
        dto.setMessage("Login successful");
        return dto;
    }
    
     public static UserResponseDTO entityToUser(User user) {
    	 UserResponseDTO userdto=new UserResponseDTO();
    	 userdto.setUsername(user.getUsername());
    	 userdto.setEmail(user.getEmail());
    	 userdto.setRole(user.getRole());
    	 return userdto;
     }
}