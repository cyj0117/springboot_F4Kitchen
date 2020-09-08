package com.aaa.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Step implements Serializable {
    private Integer sid;
    private String step;
    private String picture;
    private Integer cstepid;
    private CookBook cookBook;
    private User user;
}
