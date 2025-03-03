package com.example.springbootboard.dao;

import com.example.springbootboard.entity.Board;
import com.example.springbootboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
    @Autowired
    BoardRepository boardRepository;

    public Page<Board> getList(Pageable pageable){
        return boardRepository.findAll(pageable);
    }
}
