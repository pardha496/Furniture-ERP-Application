package com.funrierp.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.funrierp.dto.LoginResponseDTO;
import com.funrierp.dto.UserRequestDTO;
import com.funrierp.entity.User;

import ch.qos.logback.core.encoder.Encoder;
import lombok.Data;

@Data
public class UserMapper {
	
	@Autowired
	static PasswordEncoder encoder;
	
    public static User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        // password encryption
        user.setPassword(encoder.encode(user.getPassword()));
        
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
}