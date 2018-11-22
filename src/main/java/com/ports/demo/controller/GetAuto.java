package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.normal.Context;
import com.ports.demo.service.PicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetAuto {

    @Autowired
    private PicturesService picturesService;

    @RequestMapping(value = "/teacher/getAuto",method = RequestMethod.POST)
    public List<byte[]> getAuto(@RequestBody String s) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(s);
        String date = jsonObject.getString(Context.date);
        int sid = jsonObject.getInteger(Context.Student_sid);
        List<byte[]> list = picturesService.getAuto(sid,date);
        return list;
    }
}
