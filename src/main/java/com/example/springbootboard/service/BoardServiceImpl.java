package com.example.springbootboard.service;

import com.example.springbootboard.dao.BoardDAO;
import com.example.springbootboard.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    BoardDAO dao;

    // 페이지 번호를 입력받아 해당 페이지으 Page 객체를 리턴하도록 변경
    @Override
    public Page<Board> getList(int page) {
        // page: 조회할 페이지 번호, 10: 한 페이지에 보여줄 게시물 개수
        // ->  데이터 전체를 조회하지 않고 해당 페이지의 데이터만 조회하도록 쿼리 변경됨
        Pageable pageable= PageRequest.of(page,10); // Pageable 객체 생성
        return this.dao.getList(pageable);
    }
}
