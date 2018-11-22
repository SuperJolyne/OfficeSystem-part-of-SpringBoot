package com.ports.demo.service.impl;

import com.ports.demo.dao.DayRemarkDao;
import com.ports.demo.dao.QuitDao;
import com.ports.demo.domain.Quit;
import com.ports.demo.service.QuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuitServiceImpl implements QuitService {

    @Autowired
    private QuitDao quitDao;

    @Autowired
    private DayRemarkDao dayRemarkDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveQuit(int sid) {
        int dayScore = dayRemarkDao.getScore1(sid);
        dayScore = dayScore - 10;
        dayRemarkDao.score1(sid,dayScore);
        return quitDao.saveQuit(sid);
    }

    @Override
    public List<String> getQuit(int sid) {
        return quitDao.getQuit(sid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int quitRemark(int sid, String date, String remark) {
        return quitDao.quitRemark(sid, date, remark);
    }

    @Override
    public List<Quit> getQuitRemark() {
        return quitDao.getQuitRemark();
    }
}
