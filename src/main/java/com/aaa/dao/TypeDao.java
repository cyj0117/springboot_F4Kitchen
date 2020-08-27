package com.aaa.dao;

import com.aaa.entity.Type;

import java.util.List;

public interface TypeDao {
    List<Type> queryAll();
    int add(Type type);
    int update(Type type);
    int delete(int tid);
}
