package com.ports.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.domain.Quit;
import com.ports.demo.pojo.Context;
import com.ports.demo.service.QuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetQuitRemark {

    @Autowired
    private QuitService quitService;

    @RequestMapping(value = "/teacher/getQuitRemark", method = RequestMethod.POST)
    public JSONArray getQuitRemark(@RequestBody String s){
        s = s.toLowerCase();
        System.out.println("getQuitRemark:"+s);
        JSONObject json = JSONObject.parseObject(s);
        String sid = json.getString(Context.Student_sid);
        String date = json.getString(Context.date);

        List<Quit> list = quitService.getQuitRemark(sid,date);
        JSONArray jsonArray = new JSONArray();
        for(Quit q : list){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(Context.Quit_time, q.getDate());
            jsonObject.put(Context.Quit_remark, q.getReason());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
