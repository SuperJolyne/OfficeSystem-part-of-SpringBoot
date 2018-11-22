package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.domain.Calendar;
import com.ports.demo.normal.SameCode;
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

    @RequestMapping(value = "/teacher/getMonths", method = RequestMethod.GET)
    public Map<String,Object> getMonths() throws ParseException {

        List<Calendar> list= calendarService.getCalendar();

        Map<String,Object> map = SameCode.Calendar(list);
        return map;
    }
}
