package com.ports.demo.controller;

import com.ports.demo.domain.Notices;
import com.ports.demo.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetInform {

    @Autowired
    public NoticesService noticesService;

    @RequestMapping(value ="/student/getInform",method = RequestMethod.GET)
    public List<Notices> getInform(){
        List<Notices> list = noticesService.getInform();

        return list;
    }
}
