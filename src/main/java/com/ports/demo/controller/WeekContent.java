package com.ports.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
public class WeekContent {
    @Autowired
    private WeeksService weeksService;

    @RequestMapping(value = "/student/weekContent",method = RequestMethod.POST)
    public String weekContent(@RequestBody String s){
        s = s.toLowerCase();
        System.out.println("weekContent:"+s);
        JSONObject json = JSONObject.parseObject(s);
        String sid = json.getString(Context.Student_sid);
        JSONArray array = json.getJSONArray(Context.array);
        String remark = json.getString(Context.Week_remark);
        boolean b = weeksService.saveWeek(sid, array, remark);
        System.out.println(b);
        String result = "";
        if (b){
            result = "true";
        }else {
            result = "false";
        }
        return result;
    }
}
