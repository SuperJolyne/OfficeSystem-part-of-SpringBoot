package com.ports.demo.controller;

import com.ports.demo.service.PicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetPicture1 {

    @Autowired
    private PicturesService picturesService;

    @RequestMapping(value = "/teacher/getPicture1" , method = RequestMethod.GET)
    public List<Object> getPicture1() throws Exception {
        List<Object> map = picturesService.getPict1();
        return map;
    }
}
