package com.god.Object;

import java.util.Objects;

public class MyTime {
    private int year;
    private int month;
    private int day;

    public MyTime() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return  year + "年" + month + "月" + day + "日";
    }






}
