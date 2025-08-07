package com.funrierp.dto;

import com.funrierp.entity.Role;

import lombok.Data;

@Data
public class LoginResponseDTO {
	
	private String username;
    private Role role;
    private String token;
    private String message;

}
