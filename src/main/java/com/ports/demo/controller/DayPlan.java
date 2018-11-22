package com.ports.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.normal.Context;
import com.ports.demo.service.DaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DayPlan {

    @Autowired
    private DaysService daysService;

    @RequestMapping(value = "/student/dayPlan", method = RequestMethod.POST)
    public Map<String , Object> dayPlan(@RequestBody String s) {
        JSONObject jsonObject = JSONObject.parseObject(s);
        int sid = jsonObject.getInteger(Context.Student_sid);
        JSONArray jsonArray = jsonObject.getJSONArray(Context.array);
        String array = jsonArray.toJSONString();
        String dayRemark = jsonObject.getString(Context.Days_dayRemark);

        Map<String , Object> map = daysService.dayPlans(sid,array,dayRemark);

        return map;

    }
}