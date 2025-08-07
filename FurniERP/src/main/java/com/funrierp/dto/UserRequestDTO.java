package com.funrierp.dto;

import com.funrierp.entity.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequestDTO {
	
	@NotEmpty(message = "Username should not be empty")
    private String username;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Invalid email format")
    private String email;

    @NotEmpty(message = "Password should not be empty")
    private String password;

    @NotNull(message = "Role must be selected")
    private Role role;
}
