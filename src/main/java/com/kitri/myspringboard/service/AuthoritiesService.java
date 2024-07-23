package com.kitri.myspringboard.service;

import com.kitri.myspringboard.domain.Authorities;
import com.kitri.myspringboard.mapper.AuthoritiesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesService {

    @Autowired
    AuthoritiesMapper authoritiesMapper;

    public void signup(Authorities authoritie){
        authoritiesMapper.signup(authoritie);
    }

}
