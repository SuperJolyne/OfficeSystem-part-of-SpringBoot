package com.ports.demo.dao;

import com.ports.demo.domain.DayRemarks;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DayRemarkDao {

    int saveDayRemark(@Param("sid") int sid, @Param("dayRemark")String dayRemark);

    String getDayRemark(int sid);

    String getDayID(int sid);

    int updateDayRemark(@Param("sid") int sid, @Param("dayRemark")String dayRemark);

    int getScore(@Param("sid") int sid, @Param("date") String date);

    int saveScore(@Param("sid")int sid, @Param("score")int score, @Param("daycom")String daycom, @Param("date")String date);

    List<DayRemarks> getAllScore(int sid);

    DayRemarks returnScore(@Param("sid")int sid, @Param("date")String date);

    int sid(String name);

    int getScore1(@Param("sid") int sid);

    int score1(@Param("sid") int sid, @Param("score") int score);

    //周分数
    int getWeekScore(String name);

    String getDayComment(@Param("sid") int sid, @Param("date") String date);

    List<Integer> getScore2(int sid);
}
