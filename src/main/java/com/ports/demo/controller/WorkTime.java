//package com.ports.demo.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import com.ports.demo.normal.Context;
//import com.ports.demo.normal.SameCode;
//import com.ports.demo.service.CalendarService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class WorkTime {
//
//    @Autowired
//    private CalendarService calendarService;
//
//    @RequestMapping(value = "/teacher/workTime", method = RequestMethod.POST)
//    public String workTime(@RequestBody String s){
//        JSONObject jsonObject = JSONObject.parseObject(s);
//        String date = jsonObject.getString(Context.date);
//        String time = calendarService.getWorkTime(date);
//
////        String[] strings = {Context.Calendar_time};
////        Object[] objects = {time};
////        String out = SameCode.toJsonString(strings,objects);
//        return time;
//    }
//}
