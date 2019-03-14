package com.ports.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.pojo.Context;
import com.ports.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddStudent {

    @Autowired
    private StudentsService studentsService;

    @RequestMapping(value = "/teacher/addStudent", method = RequestMethod.POST)
    public String addStudent(@RequestBody String s){
        s = s.toLowerCase();
        System.out.println("addStudent:"+s);

        JSONObject jsonObject = JSONObject.parseObject(s);

            String name = jsonObject.getString(Context.Student_name);
            String sex = jsonObject.getString(Context.Student_sex);
            String num = jsonObject.getString(Context.Student_num);
            String course = jsonObject.getString(Context.Student_course);
            String school = jsonObject.getString(Context.Student_school);
            String college = jsonObject.getString(Context.Student_college);
            String classes = jsonObject.getString(Context.Student_classes);
            studentsService.addStudent(name,sex,num,course,school,college,classes);

        return "{\"result\":\"true\"}";
    }
}
