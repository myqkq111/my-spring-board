package com.kitri.myspringboard.service;

import com.kitri.myspringboard.domain.Users;
import com.kitri.myspringboard.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UsersMapper usersMapper;

    public void signUp(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersMapper.signup(user);
    }

    public int selectId(String username) {
        return usersMapper.selectId(username);
    }

}
