package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.pojo.Context;
import com.ports.demo.service.DayRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetScore {

    @Autowired
    private DayRemarkService dayRemarkService;

    @RequestMapping(value = "/student/getScore",method = RequestMethod.POST)
    public Map<String ,Object> getScore(@RequestBody String s){
        JSONObject jsonObject= JSONObject.parseObject(s);
        int sid=jsonObject.getInteger(Context.Student_sid);

        Map<String ,Object> map = dayRemarkService.getAllScore(sid);
        System.out.println("getScore:"+JSONObject.toJSONString(map));
        return map;
    }
}
