package com.ports.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.input.WeeksInput;
import com.ports.demo.pojo.Context;
import com.ports.demo.service.WeeksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetWeekRecord {

    @Autowired
    WeeksService weeksService;

    @RequestMapping(value = "/student/getWeekRecord",method = RequestMethod.POST)
    public String getWeekRecord(@RequestBody String s){
        s = s.toLowerCase();
        System.out.println(s);
        JSONObject jsonObject=JSONObject.parseObject(s);
        int sid = jsonObject.getInteger(Context.Student_sid);
        String week = jsonObject.getString("week");
        WeeksInput out=weeksService.getWeekRecordData(sid,week);
        String jsonString = JSON.toJSONString(out);
        return jsonString;


    }
}
