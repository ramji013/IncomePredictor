package com.predictor.bean;

public class IncrementReport extends IncomeReport{
    private int noOfIncrement;
    private Double incrementPercent;
    private Double incrementAmount;

    public int getNoOfIncrement() {
        return noOfIncrement;
    }

    public void setNoOfIncrement(int noOfIncrement) {
        this.noOfIncrement = noOfIncrement;
    }

    public Double getIncrementPercent() {
        return incrementPercent;
    }

    public void setIncrementPercent(Double incrementPercent) {
        this.incrementPercent = incrementPercent;
    }

    public Double getIncrementAmount() {
        return incrementAmount;
    }

    public void setIncrementAmount(Double incrementAmount) {
        this.incrementAmount = incrementAmount;
    }

    @Override
    public String toString() {
        return "IncrementReport{" +
                "noOfIncrement=" + noOfIncrement +
                ", incrementPercent=" + incrementPercent +
                ", incrementAmount=" + incrementAmount +
                '}';
    }
}
