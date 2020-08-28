package com.aaa.service;

import com.aaa.entity.Share;

import java.util.List;

public interface ShareService {
    List<Share> listShare();

    Integer delShare(Integer sid);
}
