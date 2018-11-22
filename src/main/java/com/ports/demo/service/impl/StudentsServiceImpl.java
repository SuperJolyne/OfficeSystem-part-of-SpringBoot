package com.ports.demo.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.dao.StudentsDao;
import com.ports.demo.domain.Students;
import com.ports.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private StudentsDao studentsDao;

    @Override
    public Students getNameByDate(String date) {
        return studentsDao.getName(date);
    }

    @Override
    public List<String> getHistoryDate() {
        return studentsDao.getHistoryDate();
    }

    @Override
    public String login(String name) {
        return studentsDao.login(name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int listStudents(String name,String sex,String num,String course,String school,String college,String classes) {
        return studentsDao.listStudents(name,sex,num,course,school,college,classes);
    }

    @Override
    public List<Map<String, Object>> viewStudents() {
        List<Students> list = studentsDao.viewStudents();
        List<Map<String, Object>> listName = new ArrayList<>();
        for(Students s : list){
            String name = s.getName();
            int sid = s.getSid();
            Map<String, Object> map = new HashMap<>();
            map.put("name",name);
            map.put("sid",sid);
            listName.add(map);
        }
        return listName;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addStudent(String name,String sex,String num,String course,String school, String college,String classes) {
        return studentsDao.addStudent(name,sex,num,course,school,college,classes);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteStudent(int sid) {
        return studentsDao.deleteStudent(sid);
    }

    @Override
    public List<Map<String ,Object>> getHistory(String record) {
        List<Students> list = studentsDao.getHistory(record);
        List<Map<String ,Object>> listName = new ArrayList<>();
        for(Students s : list){
            String name = s.getName();
            int score = s.getScore();
            Map<String ,Object> map = new HashMap<>();
            map.put("name",name);
            map.put("score",score);
            listName.add(map);
        }
        return listName;
    }

}
