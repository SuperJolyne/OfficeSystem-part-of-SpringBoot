package com.ports.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.pojo.Context;
import com.ports.demo.service.WeekRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class WeekComment {

    @Autowired
    private WeekRemarkService weekRemarkService;

    @RequestMapping(value = "/teacher/weekComment", method = RequestMethod.POST)
    public String weekComment(@RequestBody String s) {
        s = s.toLowerCase();
        System.out.println("weekComment"+s);
        JSONObject json = JSONObject.parseObject(s);
        String sid = json.getString(Context.Student_sid);
        String week = json.getString(Context.Week_week);
        Pattern p = Pattern.compile("\\(");
        Matcher m = p.matcher(week);
        if (m.find()){
            week = week.substring(0, 3);
        }
        String weekcom = json.getString(Context.Week_com);
        String score = json.getString(Context.DayRemark_score);

        weekRemarkService.updateCom(sid, week, weekcom, score);
        return "{\"result\":\"true\"}";
    }
}