package com.kitri.myspringboard.controller;

import com.kitri.myspringboard.domain.Comment;
import com.kitri.myspringboard.service.CommentService;
import com.kitri.myspringboard.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;
    @Autowired
    private UsersService usersService;

    @PostMapping("/add")
    public String add(@ModelAttribute Comment comment) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        comment.setUserId(usersService.selectId(authentication.getName()));

        commentService.add(comment);
        return "redirect:/board/"+comment.getBoardId();
    }

}
