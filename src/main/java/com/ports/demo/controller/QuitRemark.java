package com.ports.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.normal.Context;
import com.ports.demo.service.QuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuitRemark {

    @Autowired
    private QuitService quitService;

    @RequestMapping(value = "/student/quitRemark", method = RequestMethod.POST)
    public String quitRemark(@RequestBody String s){
        JSONArray jsonArray = JSONArray.parseArray(s);
        for(int i = 0; i < jsonArray.size(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            int sid = jsonObject.getInteger(Context.Student_sid);
            String date = jsonObject.getString(Context.date);
            String remark = jsonObject.getString(Context.Quit_remark);
            quitService.quitRemark(sid, date, remark);
        }
        return "{\"result\":\"true\"}";
    }
}
