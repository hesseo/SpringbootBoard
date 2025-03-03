package com.example.springbootboard.repository;

import com.example.springbootboard.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    // 페이징 처리
    Page<Board> findAll(Pageable pageable);
}
