package com.example.springbootboard.controller;

import com.example.springbootboard.entity.Board;
import com.example.springbootboard.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
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
    public String boardList(HttpServletRequest request,Model model, @RequestParam(value = "page", defaultValue = "0") int page){
        int pg=1;
        if (request.getParameter("pg")!=null){
            pg= Integer.parseInt(request.getParameter("pg"));
        }
        Page<Board>paging=this.boardService.getList(page);
        model.addAttribute("paging",paging);
        model.addAttribute("pg",pg);
        return "/board/boardList";
    }

    @GetMapping("/boardView")
    public String boardView(HttpServletRequest request, Model model){
        int pg= Integer.parseInt(request.getParameter("pg"));
        int seq= Integer.parseInt(request.getParameter("seq"));
        Board board=boardService.selectboard(seq);
        model.addAttribute("board",board);
        model.addAttribute("seq",seq);
        model.addAttribute("pg",pg);
        return "/board/boardView";
    }
}
