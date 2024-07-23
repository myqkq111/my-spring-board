package com.kitri.myspringboard.mapper;

import com.kitri.myspringboard.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;

    @Test
    void findAll() {
        List<Board> boards = boardMapper.findAll();
        assertThat(boards).hasSize(5);
    }

    @Test
    void findById() {

        // Given, When, Then
        Board board = new Board();
        board.setTitle("test title");
        board.setContent("test content");
        board.setWriter("test writer");
        boardMapper.insert(board);

        Board foundBoard = boardMapper.findById(board.getId());

        assertThat(foundBoard).isNotNull();
        assertThat(foundBoard.getTitle()).isEqualTo("test title");
        assertThat(foundBoard.getContent()).isEqualTo("test content");
        assertThat(foundBoard.getWriter()).isEqualTo("test writer");
    }

    @Test
    void insert() {
        Board board = new Board();
        board.setTitle("test title");
        board.setContent("test content");
        board.setWriter("test writer");
        boardMapper.insert(board);
    }

    @Test
    void update() {

        Board board = new Board();
        board.setTitle("test title");
        board.setContent("test content");
        board.setWriter("test writer");

        boardMapper.insert(board);
        Board foundBoard = boardMapper.findById(board.getId());

        foundBoard.setTitle("new title");
        foundBoard.setContent("new content");
        foundBoard.setWriter("new writer");

        boardMapper.update(foundBoard);
        boardMapper.findById(foundBoard.getId());

        assertThat(foundBoard.getTitle()).isEqualTo("new title");
        assertThat(foundBoard.getContent()).isEqualTo("new content");
        assertThat(foundBoard.getWriter()).isEqualTo("new writer");
    }

    @Test
    void delete() {
        Board board = new Board();
        board.setTitle("test title");
        board.setContent("test content");
        board.setWriter("test writer");

        boardMapper.insert(board);
        Board foundBoard = boardMapper.findById(board.getId());

        boardMapper.delete(foundBoard.getId());
        Board deletedBoard = boardMapper.findById(foundBoard.getId());

        assertThat(deletedBoard).isNull();
    }
}