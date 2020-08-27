package com.aaa.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
   private Integer uid;
   private String uname;
   private String account;
   private String password;
   private String gender;
   private String phone;
   private String money;
   private Date usertime;
   private Date bantime;
   private Integer state;
}
