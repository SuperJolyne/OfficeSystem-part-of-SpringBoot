package com.ports.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.Redis.Rediss;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushPicture {

    @RequestMapping(value = "/push/picture",method = RequestMethod.GET)
    public String pushPicture(){

        Rediss rediss = new Rediss();
        rediss.init();
        rediss.pubPict();
        rediss.dis();

        return "{\"result\":\"true\"}";
    }
}
