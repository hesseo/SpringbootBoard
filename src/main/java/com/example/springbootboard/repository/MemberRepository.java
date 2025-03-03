package com.example.springbootboard.repository;

import com.example.springbootboard.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member,String> {
    // 동적 쿼리 생성
    @Query(value = "select * from member where id=:id and pwd=:pwd", nativeQuery = true)
    Member findMemberByIdAndPwd(@Param("id") String id, @Param("pwd") String pwd);
}
