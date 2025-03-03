package com.example.springbootboard.service;

import com.example.springbootboard.dao.MemberDAO;
import com.example.springbootboard.dto.MemberDTO;
import com.example.springbootboard.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberDAO dao;

    @Override
    public Member insertMember(MemberDTO dto) {
        return dao.insertMember(dto);
    }

    @Override
    public Member checkId(String id) {
        return dao.checkId(id);
    }

    @Override
    public Member loginMember(String id, String pwd) {
        return dao.loginMember(id,pwd);
    }

    @Override
    public Member selectMember(String id) {
        return dao.selectMember(id);
    }

    @Override
    public Member updateMember(MemberDTO dto) {
        return dao.updateMember(dto);
    }
}
