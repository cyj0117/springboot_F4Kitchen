package com.aaa.service.impl;

import com.aaa.dao.StepDao;
import com.aaa.entity.Step;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class StepServiceImpl implements StepDao {

    @Resource
    StepDao stepDao;

    @Override
    public List<Step> findStep() {
        return stepDao.findStep();
    }
}
