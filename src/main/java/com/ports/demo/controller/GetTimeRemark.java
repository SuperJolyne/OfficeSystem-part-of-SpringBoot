package com.ports.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetTimeRemark {

    @RequestMapping(value = "/teacher/getTimeRemark", method = RequestMethod.GET)
    public String getTimeRemark(){
        return "{\"remark\":\"xxxxx\"}";
    }
}
