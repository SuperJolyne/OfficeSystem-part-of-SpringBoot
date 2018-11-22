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
public class WorkNot {

    @Autowired
    private CalendarService calendarService;

    @RequestMapping(value = "/teacher/workNot", method = RequestMethod.POST)
    public String workNot(@RequestBody String s) {
        JSONObject jsonObject = JSONObject.parseObject(s);
        String date = jsonObject.getString(Context.date);
        String status = jsonObject.getString(Context.Calendar_status);
        calendarService.workNot(date, status);
        return "{\"result\":\"true\"}";
    }
}
