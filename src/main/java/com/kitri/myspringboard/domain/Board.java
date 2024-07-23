package com.kitri.myspringboard.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Board {

    private int id;
    private String title;
    private String content;
    private int userId;
    private LocalDateTime createdAt;
    private String username;


}
