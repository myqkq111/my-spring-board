package com.kitri.myspringboard.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {

    private int id;

    private String content;

    private int userId;

    private int boardId;

    private LocalDateTime createdAt;

    private String username;

}
