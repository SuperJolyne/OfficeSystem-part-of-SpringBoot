package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.normal.Context;
import com.ports.demo.service.PicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class GetPicture {

    @Autowired
    private PicturesService picturesService;

    @RequestMapping(value = "/teacher/getPicture",method = RequestMethod.GET)
    public Map<String ,Object> getPicture() throws Exception {

        Map<String ,Object> map = picturesService.getPict();
        return map;
    }

}
