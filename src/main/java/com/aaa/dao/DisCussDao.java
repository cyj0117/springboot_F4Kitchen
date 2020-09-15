package com.aaa.dao;

import com.aaa.entity.Discuss;

import java.util.List;

public interface DisCussDao {
    List<Discuss> listAll();
    int add(Discuss discuss);
}
