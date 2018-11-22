package com.ports.demo.dao;


import com.ports.demo.domain.Calendar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CalendarDao {

    int insertDatelist(@Param("month") String month);

    List<Calendar> getCalendar();

    //获取月匹配是否有重复月
    String getMonth(@Param("month") String month);

    String getWorkTime(@Param("date") String date);

    String existMonths();

    int workNot(@Param("date") String date, @Param("status") String status);

    int alterWorkTime(@Param("date") String date, @Param("time") String time);

    List<Calendar> datelist();

    void setWeek(@Param("week")String week, @Param("worknot") String worknot, @Param("datelist") String datelist, @Param("weekday") int weekday);

    void setWeek1(@Param("week")String week, @Param("worknot") String worknot, @Param("datelist") String datelist, @Param("weekday") int weekday, @Param("times") String times);

    int Days();
}
