package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.pojo.Context;
import com.ports.demo.service.PicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAuto {

    @Autowired
    private PicturesService picturesService;

    @RequestMapping(value = "/teacher/getAuto",method = RequestMethod.POST)
    public List<String> getAuto(@RequestBody String s) throws Exception {
        System.out.println("getAuto:"+s);
        JSONObject jsonObject = JSONObject.parseObject(s);
        String date = jsonObject.getString(Context.date);
        int sid = jsonObject.getInteger(Context.Student_sid);
        List<String> list = picturesService.getAuto(sid,date);
        return list;
    }
}
