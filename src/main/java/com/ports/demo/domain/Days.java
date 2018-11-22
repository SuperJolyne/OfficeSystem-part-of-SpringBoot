package com.ports.demo.domain;

public class Days {

    private int did;

//    @JsonProperty(value = "aaaaaa")
    private String date;

    private String dayPlan;

    private String per;

    private int sid;

    private DayRemarks dayRemarks;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDayPlan() {
        return dayPlan;
    }

    public void setDayPlan(String dayPlan) {
        this.dayPlan = dayPlan;
    }

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

    public DayRemarks getDayRemarks() {
        return dayRemarks;
    }

    public void setDayRemarks(DayRemarks dayRemarks) {
        this.dayRemarks = dayRemarks;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}

