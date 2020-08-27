package com.aaa.service.impl;

import com.aaa.dao.TypeDao;
import com.aaa.entity.Type;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
//分类
@Service
public class TypeServiceImpl {
    @Resource
    TypeDao typeDao;
    public List<Type>queryAll(){
        return typeDao.queryAll();
    }
    public int add(Type type){
        return typeDao.add(type);
    }
    public int update(Type type){
        return typeDao.update(type);
    }
    public int delete(int tid){
        return typeDao.delete(tid);
    }
}
