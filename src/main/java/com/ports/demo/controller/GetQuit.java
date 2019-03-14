package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.pojo.Context;
import com.ports.demo.service.QuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetQuit {

    @Autowired
    private QuitService quitService;

    @RequestMapping(value = "/student/getQuit", method = RequestMethod.POST)
    public List<String> getQuit(@RequestBody String s){
        JSONObject jsonObject = JSONObject.parseObject(s);
        int sid = jsonObject.getInteger(Context.Student_sid);
        List<String> list = quitService.getQuit(sid);
        return list;
    }
}
