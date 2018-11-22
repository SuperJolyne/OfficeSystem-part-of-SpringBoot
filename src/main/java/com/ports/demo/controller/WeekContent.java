package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeekContent {
    @RequestMapping(value = "/student/weekContent",method = RequestMethod.POST)
    public String weekContent(@RequestBody String s){
        JSONObject jsonObject=JSONObject.parseObject(s);
        int count=jsonObject.size();
        String s1=jsonObject.getString("name");
        String s2=jsonObject.getString("week");
        String s3=jsonObject.getString("weekcontent");
        if(s1 !=null && s2 !=null && s3 !=null && count ==3){
            return "{\"name\":\"sss\",\"week\":\"第一周\",\"weekcontent\":\"sadasdas\"}";
        }
        else return "false";
    }
}
