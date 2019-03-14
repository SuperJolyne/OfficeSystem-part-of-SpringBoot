package com.ports.demo.controller;

import com.ports.demo.domain.Notices;
import com.ports.demo.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetRecent {

    @Autowired
    private NoticesService noticesService;

    @RequestMapping(value = "/teacher/getRecent", method = RequestMethod.GET)
    public List<Notices> getRecent(){

        List<Notices> list = noticesService.getRecent();

        return list;
    }
}
