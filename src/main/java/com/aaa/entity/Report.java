package com.aaa.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class Report {
    private Integer rid;
    private Integer creid;
    private Integer ureid;
    private Integer reportid;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date retime;
    private String reason;
    private Integer areportid;
    private Date answertime;
    private Integer creportid;

    private Answer answer;

    private User user;

    private CookBook cookBook;

    private  User users;
}
