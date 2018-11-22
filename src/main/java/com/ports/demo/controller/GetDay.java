package com.ports.demo.controller;

import com.ports.demo.service.DaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GetDay {

    @Autowired
    private DaysService daysService;

    @RequestMapping(value = "/student/getDay", method = RequestMethod.GET)
    public List<String> getDay(){
        List<String> list = daysService.getDay();
        return list;
    }
}
