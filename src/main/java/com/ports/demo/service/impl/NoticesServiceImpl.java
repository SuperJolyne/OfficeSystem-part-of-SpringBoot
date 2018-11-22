package com.ports.demo.service.impl;

import com.ports.demo.dao.NoticesDao;
import com.ports.demo.domain.Notices;
import com.ports.demo.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoticesServiceImpl implements NoticesService {

    @Autowired
    private NoticesDao noticesDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int giveInform(String inform) {
        return noticesDao.giveInform(inform);
    }

    @Override
    public List<Notices> getInform() {
        return noticesDao.getInform();
    }

    @Override
    public List<Notices> getRecent() {
        return noticesDao.getRecent();
    }
}
