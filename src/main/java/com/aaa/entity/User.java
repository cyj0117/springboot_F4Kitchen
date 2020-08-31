package com.aaa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class User {
   private Integer uid;
   private String uname;
   private String account;
   private String password;
   private String gender;
   private String phone;
   private String money;
   @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
   private Date usertime;
   @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
   private Date bantime;
   private Integer state;
   private CookBook cookBook;
   private CookUser cookUser;
}
