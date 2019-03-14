package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.domain.Calendar;
import com.ports.demo.pojo.Context;
import com.ports.demo.pojo.SameCode;
import com.ports.demo.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
public class GetCalendar {

    @Autowired
    private CalendarService calendarService;

    @RequestMapping(value = "/student/getCalendar",method = RequestMethod.POST)
    public List<JSONObject> getCalendar(@RequestBody String s) throws ParseException {
        System.out.println("/student/getCalendar:"+s);
        s = s.toLowerCase();
        JSONObject json = JSONObject.parseObject(s);
        String date = json.getString(Context.date);
        List<Calendar> list= calendarService.getCalendar(date);

        List<JSONObject> map = SameCode.Calendar(list);
        return map;
    }
}
