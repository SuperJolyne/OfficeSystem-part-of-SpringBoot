package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.normal.Context;
import com.ports.demo.normal.SameCode;
import com.ports.demo.service.PicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RestController
public class TakePicture {

    @Autowired
    private PicturesService picturesService;

    @RequestMapping(value = "/student/takePicture", method = RequestMethod.POST)
    public String takePicture(MultipartFile file) throws IOException {

        String manual = "manual";
        JSONObject json = SameCode.SavePicture(file,manual);
        String path = json.getString("path");
        int sid = json.getInteger("sid");

        //保存到mysql
        picturesService.savePict(path,sid);

        return "{\"result\":\"true\"}";
    }
}
