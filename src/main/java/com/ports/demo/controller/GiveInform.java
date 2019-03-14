package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.Redis.Rediss;
import com.ports.demo.pojo.Context;
import com.ports.demo.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GiveInform {

    @Autowired
    private NoticesService noticesService;

    @RequestMapping(value = "/teacher/giveInform", method = RequestMethod.POST)
    public String giveInform(@RequestBody String s){
        JSONObject jsonObject = JSONObject.parseObject(s);
        String notice = jsonObject.getString(Context.Notice_notice);
        noticesService.giveInform(notice);

        Rediss rediss = new Rediss();
        rediss.init();
        rediss.pubNotice();
        rediss.dis();

        return "{\"result\":\"true\"}";
    }
}
