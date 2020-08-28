package com.aaa.entity;

import lombok.Data;

import java.util.Date;

//菜谱查询
@Data
public class CookBook {
    private Integer cid;
    private String cname;
    private String picture;
    private Date uploatime;
    private Integer cstate;
}
