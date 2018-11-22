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
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RestController
public class TakeAuto {

    @Autowired
    private PicturesService picturesService;

    @RequestMapping(value = "/student/takeAuto",method = RequestMethod.POST)
    public String takeAuto(MultipartFile file) throws IOException {

        String auto = "auto";
        JSONObject json = SameCode.SavePicture(file,auto);
        String path = json.getString("path");
        int sid = json.getInteger("sid");

        picturesService.saveAuto1(path, sid);

        return "{\"result\":\"true\"}";
    }

}
