package com.aaa.dao;

import com.aaa.entity.Share;

import java.util.List;

public interface ShareDao {
    List<Share> listShare();

    Integer delShare(Integer sid);
}
