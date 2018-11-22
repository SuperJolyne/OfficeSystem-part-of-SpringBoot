package com.ports.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @RequestMapping(value = "/testtt" , method = RequestMethod.GET)
    public String test(){
        return "0gg";
    }
}
