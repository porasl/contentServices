package com.porasl.contentServices.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // For simplicity, we're using a hardcoded user. You should fetch user details from a database.
        return new User("user", "$2a$10$DOWSDsVYk8uvBFS9M90GNeIOT54pR7oHBL/4y4UlINR4N7JgIj.4a", new ArrayList<>());
    }
}
