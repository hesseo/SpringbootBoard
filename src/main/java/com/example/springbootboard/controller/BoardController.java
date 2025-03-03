package com.example.springbootboard.controller;

import com.example.springbootboard.entity.Board;
import com.example.springbootboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/boardList")
    public String boardList(Model model, @RequestParam(value = "page", defaultValue = "0") int page){
        Page<Board>paging=this.boardService.getList(page);
        model.addAttribute("paging",paging);
        return "/board/boardList";
    }
}
