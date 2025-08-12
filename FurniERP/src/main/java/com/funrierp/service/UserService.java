package com.funrierp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.funrierp.dto.UserRequestDTO;
import com.funrierp.dto.UserResponseDTO;
import com.funrierp.entity.User;

@Service
public interface UserService {

	boolean saveUser(UserRequestDTO userDetails);

	List<UserResponseDTO> getAllEmployees();

}
