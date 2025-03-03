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
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private String name;
    @Id
    private String id;
    private String pwd;
    private String gender;
    private String email1;
    private String email2;
    private String tel1;
    private String tel2;
    private String tel3;
    private String addr;
    @Temporal(TemporalType.DATE)
    private Date logtime;
}
