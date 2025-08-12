package com.funrierp.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funrierp.dto.UserRequestDTO;
import com.funrierp.dto.UserResponseDTO;
import com.funrierp.entity.User;
import com.funrierp.mapper.UserMapper;
import com.funrierp.repository.UserRepo;
import com.funrierp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRespo;
	
	@Override
	public boolean saveUser(UserRequestDTO user) {
		if(user==null) 
			return false;
		return userRespo.save(UserMapper.toEntity(user))!=null;
	}

	@Override
	public List<UserResponseDTO> getAllEmployees() {
		// TODO Auto-generated method stub
		return  userRespo.findAll().stream().map(user->UserMapper.entityToUser(user)).collect(Collectors.toList());
	}

	

}
