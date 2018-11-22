package com.ports.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetHistoryInform {
    @RequestMapping(value = "/student/getHistoryInform",method = RequestMethod.GET)
    public String getHistoryInform(){
        return "[{\"news\":\"asdasda\"},{\"news\":\"asdasda\"}]";
    }
}
