package com.aaa.dao;

import com.aaa.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    //修改用户的状态
    Integer updateState(Integer uid,Integer state);
    Integer addUser(User user);
    Integer updateUser(User user);
    Integer deleteUser(Integer uid);

}
