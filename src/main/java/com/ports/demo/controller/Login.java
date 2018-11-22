package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.normal.Context;
import com.ports.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {

    @Autowired
    private StudentsService studentsService;

    @RequestMapping(value = "/student/login", method = RequestMethod.POST)
    public String login(@RequestBody String s){
        JSONObject jsonObject = JSONObject.parseObject(s);
        String name = jsonObject.getString(Context.Student_name);
        String sid = studentsService.login(name);
        if(sid != null) {
            int i = Integer.parseInt(sid);
            JSONObject object = new JSONObject();
            object.put("sid",i);
            return object.toJSONString();
        }
        return "{\"result\":\"false\"}";
    }
}
