package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.pojo.Context;
import com.ports.demo.service.QuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveQuit {

    @Autowired
    private QuitService quitService;

    @RequestMapping(value = "/student/saveQuit", method = RequestMethod.POST)
    public String saveQuit(@RequestBody String s){
        JSONObject jsonObject = JSONObject.parseObject(s);
        int sid = jsonObject.getInteger(Context.Student_sid);
        quitService.saveQuit(sid);
        return "{\"result\":\"true\"}";
    }
}
