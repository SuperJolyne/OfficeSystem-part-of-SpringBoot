package com.ports.demo.service;

import com.ports.demo.domain.Days;


import java.util.List;
import java.util.Map;

public interface DaysService {

    Map<String, Object> planExist(int sid);

    Map<String , Object> dayPlans(int sid, String array, String dayRemark);

    List<String> getDay();

    int dayPlan(int sid, String dayPlan, int per);

    int updatePer(String did, int per);

    List<Days> getDayPlan(int sid,String date);

    Map<String , Object> getDayRecord(int sid, String date);

    List<String> getNull();

    List<Integer> getPer(String name);
}
