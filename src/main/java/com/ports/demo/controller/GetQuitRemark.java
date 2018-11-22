package com.ports.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.domain.Quit;
import com.ports.demo.normal.Context;
import com.ports.demo.service.QuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetQuitRemark {

    @Autowired
    private QuitService quitService;

    @RequestMapping(value = "/teacher/getQuitRemark", method = RequestMethod.GET)
    public JSONArray getQuitRemark(){
        List<Quit> list = quitService.getQuitRemark();
        JSONArray jsonArray = new JSONArray();
        for(Quit q : list){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(Context.Student_name, q.getStudents().getName());
            jsonObject.put(Context.date, q.getDate());
            jsonObject.put(Context.Quit_remark, q.getReason());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
