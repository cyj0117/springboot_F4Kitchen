package com.aaa.controller;

import com.aaa.entity.CookBook;
import com.aaa.entity.Step;
import com.aaa.entity.User;
import com.aaa.service.impl.CookBookServiceImpl;
import com.aaa.service.impl.StepServiceImpl;
import com.aaa.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    UserServiceImpl Impl;
    //登录界面
    @RequestMapping("login")
    public String login(){
        return "login";
    }
    //调用登录方法
    @RequestMapping("loginUser")
    @ResponseBody
    public List<User> loginUser(HttpSession session,String account,String password){
        List<User> users = Impl.login(account, password);
        session.setAttribute("list",users);
        System.out.println("登录:"+users);
        return users;
    }
//    //进入主界面
//    @RequestMapping("main")
//    public String main(){
//        return "index";
//    }

    @Resource
    StepServiceImpl stepService;
    //跳转步骤
    @RequestMapping("single-recipe")
    public String single_recipe(Model model){
        List<Step> list = stepService.findStep();
        model.addAttribute("steplist",list);
        return "single-recipe";
    }
    //跳转分类
    @RequestMapping("recipe")
    public String recipe(){
        return "recipe-v1";
    }
    //跳转推荐
    @RequestMapping("browse-recipes")
    public String browse_recipes(){
        return "browse-recipes";
    }
    //跳转博客
    @RequestMapping("blog-right")
    public String blog_right(){
        return "blog-right";
    }
    //跳转注册
    @RequestMapping("register")
    public String register(){
        return "register";
    }
    //跳转个人中心
    @RequestMapping("user-account")
    public String user_account(){
        return "user-account";
    }
    //跳转博客更多资料
    @RequestMapping("blog-details")
    public String blog_details(){
        return "blog-details";
    }
    //跳转上传菜谱
    @RequestMapping("submit-recipe")
    public String submit_recipe(){
        return "submit-recipe";
    }

    @Resource
    CookBookServiceImpl cookBookService;
    //查看菜谱
    @RequestMapping("main")
    public String findcookbook(Model model){
        List<CookBook> list = cookBookService.findCookBook();
        model.addAttribute("cookbooklist",list);
        return "index";
    }
}
