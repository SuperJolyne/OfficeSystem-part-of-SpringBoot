package com.ports.demo.controller;

import com.ports.demo.domain.Calendar;
import com.ports.demo.normal.SameCode;
import com.ports.demo.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/student/getCalendar",method = RequestMethod.GET)
    public Map<String,Object> getCalendar() throws ParseException {
        List<Calendar> list= calendarService.getCalendar();
        Map<String,Object> map = SameCode.Calendar(list);
        return map;
    }
}
