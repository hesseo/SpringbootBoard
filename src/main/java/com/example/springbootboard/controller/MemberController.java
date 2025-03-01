package com.example.springbootboard.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @GetMapping("/memberWriteForm")
    public String memberWriteForm(){
        return "/member/memberWriteForm";
    }

}
