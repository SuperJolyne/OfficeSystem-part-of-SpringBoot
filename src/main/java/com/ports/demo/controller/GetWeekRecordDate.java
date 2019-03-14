package com.ports.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.input.WeeksInput;
import com.ports.demo.pojo.Context;
import com.ports.demo.service.WeeksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class GetWeekRecordDate {

    @Autowired
    private WeeksService weeksService;

    @RequestMapping(value = "/student/getWeekRecordDate",method = RequestMethod.POST)
    public Map<String, Object> getWeekRecordDate(@RequestBody String s){
        s = s.toLowerCase();
        System.out.println("getWeekRecordDate:"+s);
        JSONObject jsonObject=JSONObject.parseObject(s);
        String sid = jsonObject.getString(Context.Student_sid);
        String week = jsonObject.getString(Context.Week_week);
        Pattern p = Pattern.compile("\\(");
        Matcher m = p.matcher(week);
        if (m.find()){
            week = week.substring(0, 3);
        }
        Map<String, Object> map = weeksService.getWeek(sid, week);
        System.out.println(map.toString());
        return map;

    }
}
