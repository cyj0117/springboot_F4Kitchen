package com.aaa.dao;

import com.aaa.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import java.util.List;
@Mapper

public interface UserDao {
    List<User> findAll();
    //修改用户的状态
    Integer addUser(User user);
    Integer updateUser(User user);
    Integer deleteUser(Integer uid);
    @Select("select * from user where account = #{param1} and password = #{param2}")
    User login( String account,String password);

}
