package com.aaa.service.impl;

import com.aaa.dao.ReportDao;
import com.aaa.entity.Report;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class ReportServiceImpl implements ReportDao {
    @Resource
    ReportDao reportDao;
    @Override
    public List<Report> Show() {
        return reportDao.Show();
    }
}
