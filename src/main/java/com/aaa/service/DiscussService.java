package com.aaa.service;

import com.aaa.entity.Discuss;

import java.util.List;

public interface DiscussService {
    List<Discuss> listAll();
    int add(Discuss discuss);
}
