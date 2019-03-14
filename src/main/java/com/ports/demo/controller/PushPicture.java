package com.ports.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.Redis.Rediss;
import com.ports.demo.pojo.Global;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PushPicture {

    @RequestMapping(value = "/push/picture",method = RequestMethod.GET)
    public String pushPicture(){

        System.out.println("抓拍");
        //抓拍马上生成随机版本码
        Global.version = UUID.randomUUID().toString().substring(0, 5);

        Rediss rediss = new Rediss();
        rediss.init();
        rediss.pubPict();
        rediss.dis();

        return "{\"result\":\"true\"}";
    }
}
