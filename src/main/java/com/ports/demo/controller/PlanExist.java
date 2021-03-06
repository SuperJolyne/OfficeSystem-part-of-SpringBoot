package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.pojo.Context;
import com.ports.demo.service.DaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PlanExist {

    @Autowired
    private DaysService daysService;

    @RequestMapping(value = "/student/planExist",method = RequestMethod.POST)
    public Map<String, Object> planExist(@RequestBody String s){
        s = s.toLowerCase();
        System.out.println("planExist"+s);
        JSONObject jsonObject= JSONObject.parseObject(s);
        int sid = jsonObject.getInteger(Context.Student_sid);
        Map<String, Object> map = daysService.planExist(sid);
        System.out.println("existmap:"+JSONObject.toJSONString(map));
        return map;

    }
}
