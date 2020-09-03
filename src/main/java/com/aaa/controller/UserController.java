package com.aaa.controller;

import com.aaa.entity.User;
import com.aaa.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    UserServiceImpl Impl;
    @RequestMapping("login")
    public String Login(String account, String password, Model model){
        User list = Impl.login(account, password);
        model.addAttribute("list",list);
        System.out.println(list);
        return "login";
    }
}
