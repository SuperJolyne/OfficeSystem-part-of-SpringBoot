package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.normal.Context;
import com.ports.demo.normal.SameCode;
import com.ports.demo.service.PicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RestController
public class TakePicture1 {

    @Autowired
    private PicturesService picturesService;

    @RequestMapping(value = "/teacher/takePicture1", method = RequestMethod.POST)
    public String takePicture1(MultipartFile file) throws IOException {

        String shot = "shot";
        JSONObject json = SameCode.SavePicture(file,shot);
        String path = json.getString("path");
        int sid = json.getInteger("sid");

        //保存到mysql
        picturesService.savePict1(path,sid);

        return "{\"result\":\"true\"}";
    }
}
