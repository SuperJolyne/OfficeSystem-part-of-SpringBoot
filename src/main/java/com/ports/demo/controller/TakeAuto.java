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
public class TakeAuto {

    @Autowired
    private PicturesService picturesService;

    @RequestMapping(value = "/student/takeAuto",method = RequestMethod.POST)
    public String takeAuto(@RequestBody String s) throws IOException {

        String auto = "auto";
        JSONObject json = SameCode.SavePicture(s,auto);
        String path = json.getString("path");
        int sid = json.getInteger("sid");

        picturesService.saveAuto1(path, sid);

        return "{\"result\":\"true\"}";
    }

}
