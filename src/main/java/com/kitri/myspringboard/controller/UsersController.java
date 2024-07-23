package com.kitri.myspringboard.controller;

import com.kitri.myspringboard.domain.Authorities;
import com.kitri.myspringboard.domain.Board;
import com.kitri.myspringboard.domain.Users;
import com.kitri.myspringboard.service.AuthoritiesService;
import com.kitri.myspringboard.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    public UsersService usersService;

    @Autowired
    public AuthoritiesService authoritiesService;

    @GetMapping("/signup")
    public String signup() {
        return "users/signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute Users user) {
        usersService.signUp(user);

        Authorities authorities = new Authorities();
        authorities.setUserId(user.getId());
        authorities.setAuthority("ROLE_USER");
        authoritiesService.signup(authorities);

        return "redirect:/login";
    }
}
