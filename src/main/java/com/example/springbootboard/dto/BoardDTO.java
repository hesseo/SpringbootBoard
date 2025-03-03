package com.example.springbootboard.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BoardDTO {
    private int seq;
    private String id;
    private String name;
    private String subject;
    private String content;
    private int hit;
    private Date logtime;
}
