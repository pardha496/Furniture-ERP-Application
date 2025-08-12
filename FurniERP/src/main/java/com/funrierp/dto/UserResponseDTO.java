package com.funrierp.dto;

import com.funrierp.entity.Role;

import lombok.Data;

@Data
public class UserResponseDTO {
	
    private String username;

    private String email;

    private Role role;

}
