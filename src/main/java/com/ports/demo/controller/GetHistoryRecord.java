package com.ports.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.domain.Students;
import com.ports.demo.normal.Context;
import com.ports.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetHistoryRecord {

    @Autowired
    private StudentsService studentsService;

    @RequestMapping(value = "/teacher/getHistoryRecord",method = RequestMethod.POST)
    public List<Map<String ,Object>> getHistory(@RequestBody String s){
        JSONObject jsonObject = JSONObject.parseObject(s);
        String record = jsonObject.getString(Context.HistoryDate_record);

        List<Map<String ,Object>> list = studentsService.getHistory(record);

        return list;
    }
}
