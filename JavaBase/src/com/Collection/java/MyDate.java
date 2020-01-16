package com.Collection.java;

import java.util.Objects;

/**
 * @author sunjiacheng
 * @create 2019-10-21-16:39
 */
public class MyDate {
    private Integer year;
    private Integer month;
    private Integer day;

    public MyDate() {
    }

    public MyDate(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return Objects.equals(getYear(), myDate.getYear()) &&
                Objects.equals(getMonth(), myDate.getMonth()) &&
                Objects.equals(getDay(), myDate.getDay());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getYear(), getMonth(), getDay());
    }
}
