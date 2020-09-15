package com.aaa.service.impl;

import com.aaa.dao.DisCussDao;
import com.aaa.entity.Discuss;
import com.aaa.service.DiscussService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DiscussServiceImpl implements DiscussService {
    @Resource
    DisCussDao disCussDao;
    @Override
    public List<Discuss> listAll() {
        return disCussDao.listAll();
    }

    @Override
    public int add(Discuss discuss) {
        int i = disCussDao.add(discuss);
        if(i ==1){
            return i;
        }else{
            return 0;
        }

    }
}
