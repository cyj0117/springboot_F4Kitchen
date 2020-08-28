package com.aaa.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Share implements Serializable {
    private Integer sid;

    private String content;

    private String picture;

    private Date sharetime;

    private Integer ushareid;

    /**
     *
     */
    private User user;
}
