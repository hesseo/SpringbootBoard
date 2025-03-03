package com.example.springbootboard.dto;

import com.example.springbootboard.entity.Member;
import lombok.Data;

import java.util.Date;

@Data
public class MemberDTO {
    private String name;
    private String id;
    private String pwd;
    private String gender;
    private String email1;
    private String email2;
    private String tel1;
    private String tel2;
    private String tel3;
    private String addr;
    private Date logtime;

    public MemberDTO() {
    }

    public Member toEntity(){
        return new Member(name,id,pwd,gender,email1,email2,tel1,tel2,tel3,addr,logtime);
    }
}
