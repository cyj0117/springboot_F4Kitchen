package com.aaa.service.impl;

import com.aaa.dao.ShareDao;
import com.aaa.entity.Share;
import com.aaa.service.ShareService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {

    @Resource
    ShareDao shareDao;
    @Override
    public List<Share> listShare() {
        return shareDao.listShare();
    }

    @Override
    public Integer delShare(Integer sid){
        return shareDao.delShare(sid);
    }
}
