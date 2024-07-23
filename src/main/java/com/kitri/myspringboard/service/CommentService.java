package com.kitri.myspringboard.service;

import com.kitri.myspringboard.domain.Comment;
import com.kitri.myspringboard.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    public List<Comment> selectAll(int id) {
        return commentMapper.selectAll(id);
    }

    public void add(Comment comment){
        commentMapper.add(comment);
    }

}
