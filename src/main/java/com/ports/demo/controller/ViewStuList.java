package com.ports.demo.controller;

import com.ports.demo.domain.Students;
import com.ports.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ViewStuList {

    @Autowired
    private StudentsService studentsService;

    @RequestMapping(value = "/teacher/viewStuList", method = RequestMethod.GET)
    public List<Map<String, Object>> viewList(){
        List<Map<String, Object>> list = studentsService.viewStudents();

        return list;
    }
}

