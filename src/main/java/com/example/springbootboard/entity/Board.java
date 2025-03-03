package com.example.springbootboard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id
    private int seq;
    private String id;
    private String name;
    private String subject;
    private String content;
    private int hit;
    @Temporal(TemporalType.DATE)
    private Date logtime;
}
