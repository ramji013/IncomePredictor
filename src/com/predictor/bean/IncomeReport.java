package com.predictor.bean;

public class IncomeReport {
    private int year;
    private Double startingSalary;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getStartingSalary() {
        return startingSalary;
    }

    public void setStartingSalary(Double startingSalary) {
        this.startingSalary = startingSalary;
    }

    @Override
    public String toString() {
        return "IncomeReport{" +
                "year=" + year +
                ", startingSalary=" + startingSalary +
                '}';
    }
}
