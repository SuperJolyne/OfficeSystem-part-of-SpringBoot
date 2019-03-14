package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.pojo.SameCode;
import com.ports.demo.service.PicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
public class TakePicture {

    @Autowired
    private PicturesService picturesService;

    @RequestMapping(value = "/student/takePicture", method = RequestMethod.POST)
    public String takePicture(@RequestBody String s) throws IOException {
        System.out.println(s);
        String manual = "manual";
        JSONObject json = SameCode.SavePicture(s,manual);
        String path = json.getString("path");
        int sid = json.getInteger("sid");

        //保存到mysql
        picturesService.savePict1(path,sid);

        return "{\"result\":\"true\"}";
    }
}
