package com.ports.demo.dao;

import com.ports.demo.domain.Days;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DaysDao {

    List<Days> planExist(int sid);

    List<String> getDay();

    int dayPlan(@Param("sid") int sid, @Param("dayPlan") String dayPlan, @Param("per") int per);

    int updatePer(@Param("did")String did, @Param("per")int per);

    List<Days> getDayPlan(@Param("sid") int sid,@Param("date") String date);

    List<Days> getDayRecord(@Param("sid") int sid, @Param("date") String date);

    List<String> getNull();

    List<Integer> getPer(String name);


}
