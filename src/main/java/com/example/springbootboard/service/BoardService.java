package com.example.springbootboard.service;

import com.example.springbootboard.entity.Board;
import org.springframework.data.domain.Page;

public interface BoardService {
    // 페이징 처리
    public Page<Board>getList(int page);

    public Board selectboard(int seq);
}
