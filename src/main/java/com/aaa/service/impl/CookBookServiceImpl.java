package com.aaa.service.impl;

import com.aaa.dao.CookBookDao;
import com.aaa.entity.CookBook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class CookBookServiceImpl implements CookBookDao {
    @Resource
    CookBookDao cookBookDao;
    @Override
    public List<CookBook> listAll() {
        return cookBookDao.listAll();
    }

    @Override
    public Integer delete(Integer cid) {
        return cookBookDao.delete(cid);
    }

    @Override
    public List<CookBook> findCookBook() {
        return cookBookDao.findCookBook();
    }
}
