package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetWeekRecordDate {
    @RequestMapping(value = "/student/getWeekRecordDate",method = RequestMethod.POST)
    public String getWeekRecordDate(@RequestBody String s){
        JSONObject jsonObject=JSONObject.parseObject(s);
        int count=jsonObject.size();
        String s1=jsonObject.getString("name");
        String s2=jsonObject.getString("week");
        if(s1 !=null && s2 !=null && count==2){
            return "{\"weekcontent\":\"asdasd\"}";
        }
        else return "false";
    }
}
