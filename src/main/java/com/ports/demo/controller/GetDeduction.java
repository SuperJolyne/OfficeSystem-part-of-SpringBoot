package com.ports.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetDeduction {

    @RequestMapping(value = "/teacher/getDeduction",method=RequestMethod.GET)
    public String getDeduction() {
        return "[{\"name\":\"xxx\",\"score\":\"98\",\"name\":\"yyy\",\"score\":\"99\"}]";
    }
}
