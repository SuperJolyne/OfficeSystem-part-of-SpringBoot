package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.pojo.Global;
import com.ports.demo.pojo.SameCode;
import com.ports.demo.service.PicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class TakePicture1 {

    @Autowired
    private PicturesService picturesService;

    @RequestMapping(value = "/teacher/takePicture1", method = RequestMethod.POST)
    public String takePicture1(@RequestBody String s) throws IOException {

        String shot = "shot";
        JSONObject json = SameCode.SavePicture(s,shot);
        String path = json.getString("path");
        int sid = json.getInteger("sid");
        path = Global.version+path; //路径加上版本码

        //保存到mysql
        picturesService.savePict1(path,sid);

        return "{\"result\":\"true\"}";
    }
}
