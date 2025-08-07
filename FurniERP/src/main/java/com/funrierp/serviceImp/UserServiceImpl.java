package com.funrierp.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funrierp.dto.UserRequestDTO;
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

	

}
