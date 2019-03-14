package com.ports.demo.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.dao.DayRemarkDao;
import com.ports.demo.dao.StudentsDao;
import com.ports.demo.domain.DayRemarks;
import com.ports.demo.pojo.Context;
import com.ports.demo.service.DayRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DayRemarkServiceImpl implements DayRemarkService {

    @Autowired
    private DayRemarkDao dayRemarkDao;

    @Autowired
    private StudentsDao studentsDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveDayRemark(int sid, String dayRemark) {
        return dayRemarkDao.saveDayRemark(sid,dayRemark);
    }

    @Override
    public String getDayRemark(int sid) {
        return dayRemarkDao.getDayRemark(sid);
    }

    @Override
    public String getDayID(int sid) {
        return dayRemarkDao.getDayID(sid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateDayRemark(int sid, String dayRemark) {
        return dayRemarkDao.updateDayRemark(sid, dayRemark);
    }

    @Override
    public String getScore(int sid,String date) {
        return dayRemarkDao.getScore(sid,date);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveScore(int sid, int score, String daycom, String date) {
        return dayRemarkDao.saveScore(sid,score,daycom,date);
    }

    @Override
    public Map<String ,Object> getAllScore(int sid) {
        List<DayRemarks> list = dayRemarkDao.getAllScore(sid);
        JSONArray array = new JSONArray();
        for(DayRemarks d : list){
            JSONObject object = new JSONObject();
            object.put(Context.date,d.getDate());
            object.put(Context.DayRemark_score,d.getScore());
            object.put(Context.Days_dayRemark,d.getDayRemark());
            array.add(object);
        }
        int finalScore = studentsDao.getScore(sid);
        Map<String ,Object> map = new HashMap<>();
        map.put("array",array);
        map.put("final",finalScore);
        return map;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DayRemarks returnScore(int sid, int score, String daycom, String date) {
        int i = Integer.parseInt(dayRemarkDao.getScore(sid,date));
        int fi = i-score;
        dayRemarkDao.koufen(score,date,sid);
        dayRemarkDao.saveScore(sid,fi,daycom,date);
        return dayRemarkDao.returnScore(sid,date);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int sid(String name) {
        return dayRemarkDao.sid(name);
    }

    @Override
    public int getScore1(int sid) {
        return dayRemarkDao.getScore1(sid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int score1(int sid, int score) {
        return dayRemarkDao.score1(sid,score);
    }

    //周分数
    @Override
    public int getWeekScore(String name) {
        return dayRemarkDao.getWeekScore(name);
    }


}
