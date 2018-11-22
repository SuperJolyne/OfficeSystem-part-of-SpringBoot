package com.ports.demo.domain;

public class Calendar {

    private String datelist;

    private String worknot;

    private String times;

    private String week;

    private int weekday;


    public String getDatelist() {
        return datelist;
    }

    public void setDatelist(String datelist) {
        this.datelist = datelist;
    }

    public String getWorknot() {
        return worknot;
    }

    public void setWorknot(String worknot) {
        this.worknot = worknot;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }
}
