package com.ports.demo.dao;

import com.ports.demo.domain.Students;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentsDao {

    Students getName(String date);

    List<String> getHistoryDate();

    String login(String name);

    int listStudents(@Param("name") String name, @Param("sex") String sex, @Param("num")String num, @Param("course")String course,
                     @Param("school")String school, @Param("college")String college, @Param("classes")String classes);

    List<Students> viewStudents();

    int addStudent(@Param("name") String name, @Param("sex") String sex, @Param("num")String num, @Param("course")String course,
                   @Param("school")String school, @Param("college")String college, @Param("classes")String classes);

    int deleteStudent(int sid);

    void saveScore(@Param("sid") int sid, @Param("score") int score);

    int getScore(int sid);

    List<Students> getHistory(String record);

    String getNameBySid(@Param("sid") int sid);
}
