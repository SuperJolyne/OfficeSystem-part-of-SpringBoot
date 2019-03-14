package com.ports.demo.domain;

public class DayRemarks {

    private int rid;

    private String date;

    private String dayRemark;

    private int score;

    private String comment;

    private int sid;

    private Days days;

    public String getKoufen() {
        return koufen;
    }

    public void setKoufen(String koufen) {
        this.koufen = koufen;
    }

    private String koufen;

    public Days getDays() {
        return days;
    }

    public void setDays(Days days) {
        this.days = days;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDayRemark() {
        return dayRemark;
    }

    public void setDayRemark(String dayRemark) {
        this.dayRemark = dayRemark;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
