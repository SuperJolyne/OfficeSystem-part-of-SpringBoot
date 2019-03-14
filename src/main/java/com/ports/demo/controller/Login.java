package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.pojo.Context;
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
        System.out.println(s);
        JSONObject jsonObject = JSONObject.parseObject(s);
        String name = jsonObject.getString(Context.Student_name);
        String num = jsonObject.getString(Context.Student_num);
        String sid = studentsService.login(num);
        System.out.println(sid);
        if(sid != null) {
            int i = Integer.parseInt(sid);
            JSONObject object = new JSONObject();
            object.put("sid",i);
            object.put("res", "true");
            return object.toJSONString();
        }
        return "{\"res\":\"false\"}";
    }
}
