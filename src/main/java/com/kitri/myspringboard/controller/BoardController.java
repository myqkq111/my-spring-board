package com.kitri.myspringboard.controller;

import com.kitri.myspringboard.domain.Board;
import com.kitri.myspringboard.domain.Comment;
import com.kitri.myspringboard.service.BoardService;
import com.kitri.myspringboard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    CommentService commentService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> list = boardService.findAll();
        model.addAttribute("boards", list);
        return "board/list";
    }

    @GetMapping("{id}")
    public String show(@PathVariable int id, Model model) {
        Board board = boardService.findById(id);
        List<Comment> list = commentService.selectAll(id);
        model.addAttribute("board", board);
        model.addAttribute("comments", list);
        return "board/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        Board board = boardService.findById(id);
        model.addAttribute("board", board);
        return "board/edit";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username",authentication.getName());

        return "board/add";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute Board board) {
        boardService.insert(board);
        return "redirect:/board/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Board board) {
        boardService.update(board);
        return "redirect:/board/list";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        boardService.delete(id);
        return "redirect:/board/list";
    }

    @GetMapping("/filter")
    public String filter(@RequestParam String filter, @RequestParam String categori, Model model) {
        List<Board> list = boardService.filterBoard(filter,categori);
        model.addAttribute("boards", list);
        return "board/list";
    }

//    @GetMapping("/page/{num}")
//    public String page(@PathVariable int num, Model model) {
//
//    }
}