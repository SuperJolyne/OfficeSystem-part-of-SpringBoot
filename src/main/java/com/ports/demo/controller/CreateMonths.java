package com.ports.demo.controller;

import com.ports.demo.domain.Calendar;
import com.ports.demo.pojo.SameCode;
import com.ports.demo.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
public class CreateMonths {

    @Autowired
    private CalendarService calendarService;

    @RequestMapping(value = "/teacher/createMonths", method = RequestMethod.POST)
    public String createMonths(@RequestBody String s) throws ParseException, SQLException {

        s = s.toLowerCase();
        System.out.println(s);
        calendarService.createMonth(s);

        return "{\"result\":\"true\"}";

    }
}
