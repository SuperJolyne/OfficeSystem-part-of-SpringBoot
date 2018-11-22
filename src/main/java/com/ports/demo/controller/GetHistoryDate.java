package com.ports.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.normal.Context;
import com.ports.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetHistoryDate {

    @Autowired
    private StudentsService studentsService;

    @RequestMapping(value = "/teacher/getHistoryDate", method = RequestMethod.GET)
    public List<String> getHistory(){

        List<String> list = studentsService.getHistoryDate();

        return list;
    }
}
