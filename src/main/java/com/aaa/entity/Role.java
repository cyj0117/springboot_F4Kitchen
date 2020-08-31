package com.aaa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;


@Data
public class Role implements Serializable {
    private static final long serialVersionUID = 576973724689172979L;

    private Integer rid;

    private String rname;

    private String roledesc;

    private String rolecode;

    private Integer states;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

}