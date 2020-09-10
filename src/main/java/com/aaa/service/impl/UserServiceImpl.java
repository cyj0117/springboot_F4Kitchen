package com.aaa.service.impl;

import com.aaa.dao.UserDao;
import com.aaa.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserDao {
    @Resource
    UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> findById(Integer uid) {
        return userDao.findById(uid);
    }


    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public Integer deleteUser(Integer uid) {
        return userDao.deleteUser(uid);
    }

    @Override
    public List<User> login(String account, String password) {
        return userDao.login(account, password);
    }

    @Override
    public List<User> findAccount(String account) {
        return userDao.findAccount(account);
    }

    @Override
    public List<User> findPhone(String phone) {
        return userDao.findPhone(phone);
    }
}
