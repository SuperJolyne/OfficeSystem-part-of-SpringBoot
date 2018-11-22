package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.domain.Days;
import com.ports.demo.normal.Context;
import com.ports.demo.service.DaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetDayPlan {

    @Autowired
    private DaysService daysService;

    @RequestMapping(value = "/student/getDayPlan",method = RequestMethod.POST)
    public List<Days> getDayPlan(@RequestBody String s){
        JSONObject jsonObject = JSONObject.parseObject(s);
        int sid = jsonObject.getInteger(Context.Student_sid);
        String date = jsonObject.getString(Context.date);

        List<Days> list = daysService.getDayPlan(sid,date);

        return list;
    }
}
