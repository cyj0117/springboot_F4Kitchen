package com.aaa.until;/*
 */

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * 田常乐
 */
public class Test {

    public static void main(String[] args) {
        String pass = "123";
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bcryptPasswordEncoder.encode(pass);
        System.out.println(hashPass);

        boolean flag = bcryptPasswordEncoder.matches("123",hashPass);
        System.out.println(flag);
    }


}
