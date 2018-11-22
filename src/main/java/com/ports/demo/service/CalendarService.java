package com.ports.demo.service;

import com.ports.demo.domain.Calendar;

import java.text.ParseException;
import java.util.List;

public interface CalendarService {

    List<Calendar> createMonth(String s) throws ParseException;

    int insertDatelist(String month);

    List<Calendar> getCalendar();

    String getMonth(String month);//获取月匹配是否有重复月

    String getWorkTime(String date);

    String existMonths();

    int workNot(String date, String status);

    int alterWorkTime(String date, String time);

    List<Calendar> datelist();

    void setWeek(String week, String worknot, String date, int weekday);

    int Days();
}
