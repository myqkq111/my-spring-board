package com.kitri.myspringboard.domain;

import lombok.Data;

@Data
public class Users {

    private int id;
    private String username;
    private String password;
    private boolean enabled;

}
