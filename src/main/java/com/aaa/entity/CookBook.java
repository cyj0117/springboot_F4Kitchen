package com.aaa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

//菜谱查询
@Data
public class CookBook {
    private Integer cid;
    private String cname;
    private String picture;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date uploadtime;
    private Integer cstate;

}
