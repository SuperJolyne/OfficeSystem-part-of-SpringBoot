package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;

@RestController
public class ExistMonths {

    @Autowired
    private CalendarService calendarService;

    @RequestMapping(value = "/teacher/existMonths", method = RequestMethod.GET)
    public String existMonths(){
        String result = "false";
        String s = calendarService.existMonths();
        if(s != null){
            result = "true";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        String out = jsonObject.toJSONString();
        return out;
    }
}
