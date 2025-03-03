package com.example.springbootboard.service;

import com.example.springbootboard.dto.MemberDTO;
import com.example.springbootboard.entity.Member;

public interface MemberService {
    public Member insertMember(MemberDTO dto);
    public Member checkId(String id);
    public Member loginMember(String id, String pwd);
    public Member selectMember(String id);
    public Member updateMember(MemberDTO dto);

}
