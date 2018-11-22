package com.ports.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.normal.Context;
import com.ports.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteStudent {

    @Autowired
    private StudentsService studentsService;

    @RequestMapping(value = "/teacher/deleteStudent", method = RequestMethod.POST)
    public String deleteStudent(@RequestBody String s){
        JSONArray jsonArray = JSONArray.parseArray(s);
        int size  = jsonArray.size();
        for(int i=0;i<size;i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            int sid = jsonObject.getInteger(Context.Student_sid);
            studentsService.deleteStudent(sid);
        }
        return "{\"result\":\"true\"}";
    }
}
