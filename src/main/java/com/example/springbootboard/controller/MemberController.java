package com.example.springbootboard.controller;


import com.example.springbootboard.dto.MemberDTO;
import com.example.springbootboard.entity.Member;
import com.example.springbootboard.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
//TODO entity와 DTO 변환위치 고민
@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @PutMapping("/memberModify")
    public String memberModify(MemberDTO dto, HttpServletRequest request, Model model){
        boolean result=false;
        dto.setLogtime(new Date());
        Member member=memberService.updateMember(dto);
        if (member!=null){
            result=true;
        }
        model.addAttribute("result", result);
        return "/member/memberModify";
    }

    @GetMapping("/memberModifyForm")
    public String modifyMemberForm(HttpServletRequest request, Model model){
        HttpSession session=request.getSession();
        Member member=memberService.selectMember((String) session.getAttribute("id"));
        model.addAttribute("member", member);
        return "/member/memberModifyForm";
    }
    @PostMapping("/logout")
    // RESTful API 원칙 때문에
    // get: 데이터 조회할 때 post/put/delete: 데이터 변경할 때
    //                      put: 데이터 수정, post: 새로운 데이터 생성
    // 로그아웃-> 서버에 있는 세션 변경이므로 post가 적합
    public String logout(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.removeAttribute("id");
        session.removeAttribute("name");
        session.invalidate();
        return "/member/logout";
    }
    @PostMapping("/login")
    public String login(Model model, HttpServletRequest request){
        boolean result=false;
        HttpSession session=request.getSession();
        String id=request.getParameter("id");
        String pwd=request.getParameter("pwd");
        Member member=memberService.loginMember(id,pwd);
        if (member!=null){
            session.setAttribute("id",id);
            session.setAttribute("name",member.getName());
            result=true;
        }
        model.addAttribute("result",result);

        return "/member/login";
    }
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
        dto.setLogtime(new Date());
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
