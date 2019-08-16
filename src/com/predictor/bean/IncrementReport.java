package com.predictor.bean;

public class IncrementReport extends IncomeReport{
    private int noOfIncrement;
    private int incrementPercent;
    private Double incrementAmount;

    public int getNoOfIncrement() {
        return noOfIncrement;
    }

    public void setNoOfIncrement(int noOfIncrement) {
        this.noOfIncrement = noOfIncrement;
    }

    public int getIncrementPercent() {
        return incrementPercent;
    }

    public void setIncrementPercent(int incrementPercent) {
        this.incrementPercent = incrementPercent;
    }

    public Double getIncrementAmount() {
        return incrementAmount;
    }

    public void setIncrementAmount(Double incrementAmount) {
        this.incrementAmount = incrementAmount;
    }
}
