package com.aaa.dao;

import com.aaa.entity.CookBook;

import java.util.List;

public interface CookBookDao {
    List<CookBook> listAll();
    Integer delete(Integer cid);
    List<CookBook> findCookBook();
}
