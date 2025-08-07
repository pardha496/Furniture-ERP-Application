package com.funrierp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginRequestDTO {
	
	@NotEmpty(message = "Username should not be empty")
    private String username;
	
	@NotEmpty(message = "Password should not be empty")
    private String password;
}