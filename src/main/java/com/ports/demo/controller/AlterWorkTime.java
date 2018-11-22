package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.normal.Context;
import com.ports.demo.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlterWorkTime {

    @Autowired
    private CalendarService calendarService;

    @RequestMapping(value = "/teacher/workTime/alter", method = RequestMethod.POST)
    public String alterTime(@RequestBody String s){
        JSONObject jsonObject = JSONObject.parseObject(s);
        String date = jsonObject.getString(Context.date);
        String workTime = jsonObject.getString(Context.workTime);
        int i = calendarService.alterWorkTime(date, workTime);
        JSONObject json = new JSONObject();
        String result = "false";
        if(i != 0){
            result = "true";
        }
        json.put("result",result);
        String out = json.toJSONString();
        return out;
    }
}
