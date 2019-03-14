package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.pojo.Context;
import com.ports.demo.service.DaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetDayRecord {

    @Autowired
    private DaysService daysService;

    @RequestMapping(value = "/student/getDayRecord",method = RequestMethod.POST)
    public Map<String , Object> getDayRecord(@RequestBody String s){
        s = s.toLowerCase();
        System.out.println("getDayRecord:"+s);
        JSONObject jsonObject=JSONObject.parseObject(s);
        int sid=jsonObject.getInteger(Context.Student_sid);
        String date=jsonObject.getString(Context.date);

        Map<String , Object> map = daysService.getDayRecord(sid,date);

        return map;
    }
}
