package com.funrierp.service;

import org.springframework.stereotype.Service;

import com.funrierp.dto.UserRequestDTO;

@Service
public interface UserService {

	boolean saveUser(UserRequestDTO userDetails);

}
