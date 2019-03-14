package com.ports.demo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.dao.CalendarDao;
import com.ports.demo.domain.Calendar;
import com.ports.demo.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    private CalendarDao calendarDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createMonth(String s) throws ParseException {
        JSONObject jsonObject = JSONObject.parseObject(s);
        JSONArray jsonArray = jsonObject.getJSONArray("month");

        //正确步骤：先删除数据库中的日历再插入

        //生成日历月份
        for(int i=0; i< jsonArray.size(); i++){
            String s1 = jsonArray.getString(i);
            String l1 = calendarDao.getMonth(s1);
            if(s1.equals(l1)){
                continue;
            }else { calendarDao.insertDatelist(s1);}
        }

        //生成第几周和工作日选择
        List<Calendar> datelist = calendarDao.datelist();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date Sdate = format.parse(datelist.get(0).getDatelist());//获取日历第一天为初始日期
        java.util.Calendar sc = java.util.Calendar.getInstance();
        sc.setTime(Sdate);
        int stone = sc.get(java.util.Calendar.WEEK_OF_YEAR);//设置该天为一周的开始

//        List<Calendar> clist = new ArrayList<>();
        for(Calendar c : datelist) { //遍历所有日期
            String sdate = c.getDatelist();

            Date date = format.parse(c.getDatelist());
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTime(date);
            //计算出该日期为第几周
            int ci = calendar.get(java.util.Calendar.WEEK_OF_YEAR);
            int diff = ci - stone + 1;
            String week = "第" + diff + "周";
            //计算出日期为星期几n
            int weekday = 0;
            if (calendar.get(java.util.Calendar.DAY_OF_WEEK) == 1) {
                weekday = 7;
            } else {
                weekday = calendar.get(java.util.Calendar.DAY_OF_WEEK) - 1;
            }

            String worknot = "";
            String times = "休息";
            if (weekday == 6 || weekday == 7) {
                worknot = "rest";
                calendarDao.setWeek1(week, worknot, sdate, weekday, times);
            } else {
                worknot = "work";
                calendarDao.setWeek(week, worknot, sdate, weekday);
            }

        }
    }

    @Override
    public int insertDatelist(String month) {
        return calendarDao.insertDatelist(month);
    }

    @Override
    public List<Calendar> getCalendar(String date) {
        return calendarDao.getCalendar(date);
    }

    //获取月匹配是否有重复月
    @Override
    public String getMonth(String month) {
        return calendarDao.getMonth(month);
    }

    @Override
    public String getWorkTime(String date) {
        return calendarDao.getWorkTime(date);
    }

    @Override
    public String existMonths() {
        return calendarDao.existMonths();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int workNot(String date, String status) {
        if(status.equals("rest")) {
            System.out.println("rest");
            calendarDao.alterWorkTime(date,"休息");
        }
        return calendarDao.workNot(date, status);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int alterWorkTime(String date, String time) {
        return calendarDao.alterWorkTime(date, time);
    }

    @Override
    public List<Calendar> datelist() {
        return calendarDao.datelist();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void setWeek(String week, String worknot, String date, int weekday) {
        calendarDao.setWeek(week, worknot, date, weekday);
    }

    @Override
    public int Days() {
        return calendarDao.Days();
    }

    @Override
    public List<String> getMon() {
        return calendarDao.getMon();
    }

    @Override
    public List<String> getWeeks() {
        List<Calendar> list = calendarDao.getWeeks();
        Set<String> w_set = new HashSet<>();
        Map<String,List<String>> map = new HashMap<>();
        List<String> week_list = new ArrayList<>();
        for (Calendar c : list){
            String datelist = c.getDatelist();
            String week = c.getWeek();
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            w_set.add(week);
            if (datelist.equals(format)){
                List<String> l = map.get(week);
                if (l == null){
                    l = new ArrayList<>();
                }
                l.add(datelist);
                map.put(week, l);
                break;
            }
            List<String> l = map.get(week);
            if (l == null){
                l = new ArrayList<>();
            }
            l.add(datelist);
            map.put(week, l);
        }
        for (String week : w_set){
            List<String> l = map.get(week);
            String from = l.get(0).substring(5).replace("-", "/");
            String end = l.get(l.size()-1).substring(5).replace("-", "/");
            //拼接起来
            String s = week+"("+from+"-"+end+")";
            week_list.add(s);
        }
        return week_list;
    }


}
