package com.predictor.bean;

public class DeductionReport extends IncomeReport{

    private int noOfDeduction;
    private Double deductionPercent;
    private Double deductionAmount;

    public int getNoOfDeduction() {
        return noOfDeduction;
    }

    public void setNoOfDeduction(int noOfDeduction) {
        this.noOfDeduction = noOfDeduction;
    }

    public Double getDeductionPercent() {
        return deductionPercent;
    }

    public void setDeductionPercent(Double deductionPercent) {
        this.deductionPercent = deductionPercent;
    }

    public Double getDeductionAmount() {
        return deductionAmount;
    }

    public void setDeductionAmount(Double deductionAmount) {
        this.deductionAmount = deductionAmount;
    }
}
