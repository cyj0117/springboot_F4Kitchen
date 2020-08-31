package com.aaa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Share implements Serializable {
    private Integer sid;

    private String content;

    private String picture;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sharetime;

    private Integer ushareid;

    /**
     *
     */
    private User user;
}
