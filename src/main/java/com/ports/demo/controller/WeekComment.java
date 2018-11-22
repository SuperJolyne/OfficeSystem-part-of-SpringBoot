package com.ports.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeekComment {

    @RequestMapping(value = "/teacher/weekComment", method = RequestMethod.POST)
    public String weekComment(@RequestBody String s) {
        JSONArray object = JSONArray.parseArray(s);
        JSONObject jsonObject = object.getJSONObject(0);
        String s1 = jsonObject.getString("name");
        String i1 = jsonObject.getString("score");
        int count = jsonObject.keySet().size();
        if (s1 != null && i1 != null && count == 2) {
            String jsonString = JSONArray.toJSONString(object);
            return jsonString;
            }
        return "false";
    }
}