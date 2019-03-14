package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.domain.DayRemarks;
import com.ports.demo.pojo.Context;
import com.ports.demo.service.DayRemarkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DayComment {

    @Autowired
    private DayRemarkService dayRemarkService;

    @RequestMapping(value = "/teacher/dayComment", method = RequestMethod.POST)
    public DayRemarks dayComment(@RequestBody String s) {
        s = s.toLowerCase();
        System.out.println("dayComment:"+s);
        JSONObject jsonObject = JSONObject.parseObject(s);
        int sid = jsonObject.getInteger(Context.Student_sid);
        int score = jsonObject.getInteger(Context.DayRemark_score);
        String daycom = jsonObject.getString(Context.DayRemark_comment);
        String date = jsonObject.getString(Context.date);

        DayRemarks day = dayRemarkService.returnScore(sid,score,daycom,date);

        return day;
    }
}
