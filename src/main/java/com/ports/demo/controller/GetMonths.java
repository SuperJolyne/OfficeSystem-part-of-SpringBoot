package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.domain.Calendar;
import com.ports.demo.pojo.Context;
import com.ports.demo.pojo.SameCode;
import com.ports.demo.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;


@RestController
public class GetMonths {

    @Autowired
    private CalendarService calendarService;

    @RequestMapping(value = "/teacher/getMonths", method = RequestMethod.POST)
    public List<JSONObject> getMonths(@RequestBody String s) throws ParseException {
        s = s.toLowerCase();
        JSONObject json = JSONObject.parseObject(s);
        String date = json.getString(Context.date);

        List<Calendar> list= calendarService.getCalendar(date);

        List<JSONObject> map = SameCode.Calendar(list);
        return map;
    }
}
