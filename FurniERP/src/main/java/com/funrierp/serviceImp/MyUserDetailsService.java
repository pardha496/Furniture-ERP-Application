package com.funrierp.serviceImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.funrierp.entity.User;
import com.funrierp.entity.UserPrincipal;
import com.funrierp.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);
        if (user.isEmpty()) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }
        
        return new UserPrincipal(user.get());
    }
}
