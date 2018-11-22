package com.ports.demo.service;

import com.ports.demo.domain.DayRemarks;

import java.util.Map;

public interface DayRemarkService {

    int saveDayRemark(int sid, String dayRemark);

    String getDayRemark(int sid);

    String getDayID(int sid);

    int updateDayRemark(int sid, String dayRemark);

    int getScore(int sid, String date);

    int saveScore(int sid, int score, String daycom,String date);

    Map<String ,Object> getAllScore(int sid);

    DayRemarks returnScore(int sid, int score, String daycom, String date);

    int sid(String name);

    int getScore1(int sid);

    int score1(int sid,int score);

    //周分数
    int getWeekScore(String name);
}
