package com.predictor.bean;

public class DeductionReport extends IncomeReport{

    private int noOfDeduction;
    private int deductionPercent;
    private Double deductionAmount;

    public int getNoOfDeduction() {
        return noOfDeduction;
    }

    public void setNoOfDeduction(int noOfDeduction) {
        this.noOfDeduction = noOfDeduction;
    }

    public int getDeductionPercent() {
        return deductionPercent;
    }

    public void setDeductionPercent(int deductionPercent) {
        this.deductionPercent = deductionPercent;
    }

    public Double getDeductionAmount() {
        return deductionAmount;
    }

    public void setDeductionAmount(Double deductionAmount) {
        this.deductionAmount = deductionAmount;
    }
}
