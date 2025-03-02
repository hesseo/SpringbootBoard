package com.example.springbootboard.controller;


import com.example.springbootboard.dto.MemberDTO;
import com.example.springbootboard.entity.Member;
import com.example.springbootboard.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;
    @GetMapping("/loginForm")
    public String loginForm(){
        return "/member/loginForm";
    }
    @GetMapping("/checkId")
    @ResponseBody
    public Map<String, Boolean> checkId(HttpServletRequest request, Model model){
        boolean result=false;
        String id=request.getParameter("id");
        Member member=memberService.checkId(id);
        if(member==null){
            result=true;    // id 중복x
        }
        Map<String,Boolean>response=new HashMap<>();
        response.put("result",result);
        model.addAttribute("result",result);
        return response;
    }
    @PostMapping("/memberWrite")
    public String memberWrite(MemberDTO dto, HttpServletRequest request, Model model){
        boolean result=false;
        Member member=memberService.insertMember(dto);
        if(member!=null){
            result=true;
        }
        model.addAttribute("result",result);
        return "/member/memberWrite";
    }
    @GetMapping("/memberWriteForm")
    public String memberWriteForm(){
        return "/member/memberWriteForm";
    }

}
