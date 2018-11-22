package com.ports.demo.service;

import com.ports.demo.domain.Students;

import java.util.List;
import java.util.Map;

public interface StudentsService {

    Students getNameByDate(String date); //根据年份选择学生名单，未用上

    List<String> getHistoryDate();

    String login(String name);

    int listStudents(String name,String sex,String num,String course,String school,
                     String college,String classes);

    List<Map<String, Object>> viewStudents();

    int addStudent(String name,String sex,String num,String course,String school,
                   String college,String classes);

    int deleteStudent(int sid);

    List<Map<String ,Object>> getHistory(String record);

}
