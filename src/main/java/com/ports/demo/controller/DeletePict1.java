package com.ports.demo.controller;

import com.ports.demo.service.PicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeletePict1 {

    @Autowired
    private PicturesService picturesService;

    @RequestMapping(value = "/teacher/deleteshot",method = RequestMethod.GET)
    public String deleteshot(){
        picturesService.deletePict1();
        return "{\"result\":\"true\"}";
    }
}
