package com.predictor.bean;

public class Prediction extends IncomeReport{

    private Double incrementAmount;
    private Double deductionAmount;
    private Double salaryGrowth;

    public Double getIncrementAmount() {
        return incrementAmount;
    }

    public void setIncrementAmount(Double incrementAmount) {
        this.incrementAmount = incrementAmount;
    }

    public Double getDeductionAmount() {
        return deductionAmount;
    }

    public void setDeductionAmount(Double deductionAmount) {
        this.deductionAmount = deductionAmount;
    }

    public Double getSalaryGrowth() {
        return salaryGrowth;
    }

    public void setSalaryGrowth(Double salaryGrowth) {
        this.salaryGrowth = salaryGrowth;
    }
}
