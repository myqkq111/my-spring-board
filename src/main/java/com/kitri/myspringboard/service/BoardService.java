package com.kitri.myspringboard.service;

import com.kitri.myspringboard.domain.Board;
import com.kitri.myspringboard.mapper.BoardMapper;
import com.kitri.myspringboard.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardMapper boardMapper;

    @Autowired
    UsersService usersService;


    public List<Board> findAll(){
        return boardMapper.findAll();
    }

    public Board findById(int id){
        Board board = boardMapper.findById(id);
        board.setUserId(usersService.selectId(board.getUsername()));
        return board;
    }

    public void insert(Board board){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        board.setUserId(usersService.selectId(authentication.getName()));
        boardMapper.insert(board);
    }

    public void update(Board board){
        boardMapper.update(board);
    }

    public void delete(int id){
        boardMapper.delete(id);
    }

    public List<Board> filterBoard(String filter, String categori){
        return boardMapper.filterBoard(filter, categori);
    }

    public List<Board> page(int start){
        return boardMapper.page(start);
    }

}
