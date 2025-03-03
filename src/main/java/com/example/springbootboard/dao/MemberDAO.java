package com.example.springbootboard.dao;

import com.example.springbootboard.dto.MemberDTO;
import com.example.springbootboard.entity.Member;
import com.example.springbootboard.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
    @Autowired
    MemberRepository memberRepository;

    public Member insertMember(MemberDTO dto){
        if (memberRepository.existsById(dto.getId())){
            return null;
        }else {
            return memberRepository.save(dto.toEntity());
        }
    }

    public Member checkId(String id){
        return memberRepository.findById(id).orElse(null);
    }

    public Member loginMember(String id, String pwd){
        // select * from member where id=, pwd=
        return memberRepository.findMemberByIdAndPwd(id, pwd);
    }

    public Member selectMember(String id){
        return memberRepository.findById(id).orElse(null);
    }

    public Member updateMember(MemberDTO dto){
        if (memberRepository.existsById(dto.getId())){
            return memberRepository.save(dto.toEntity());
        }else{
            return null;
        }
    }
}
