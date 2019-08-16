package com.predictor;

import com.predictor.bean.DeductionReport;
import com.predictor.bean.IncrementReport;
import com.predictor.bean.Prediction;
import com.predictor.frequency.FrequencyWeight;
import com.predictor.msg.constant.PromptMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IncomePredictor {

    static Double salary = 0.0;
    static Double incrementSalary = 0.0;
    static Double increment = 0.0;
    static Double incrementFrequency = 0.0;
    static Double deduction = 0.0;
    static Double deductionFrequency = 0.0;
    static int predictionYear = 0;
    static int currentYear = 2019;
    static Double deductionSalary = 0.0;

    IncomePredictor(){
        Scanner readInput = new Scanner(System.in);
        salary = validateData(
                PromptMessage.INVALID_SALARY.getMessage(), PromptMessage.ENTER_START_SALARY.getMessage(), readInput);

        increment = validateData(
                PromptMessage.INVALID_INCREMENT.getMessage(), PromptMessage.ENTER_INCREMENT_TO_RECEIVE.getMessage(), readInput);

        incrementFrequency = validateData(
                PromptMessage.INVALID_FREQUENCY.getMessage(), PromptMessage.FREQUENCY_OF_INCREMENT.getMessage(), readInput);

        deduction = validateData(
                PromptMessage.INVALID_DEDUCTION.getMessage(), PromptMessage.DEDUCTION_OF_INCOME.getMessage(), readInput);

        deductionFrequency = validateData(
                PromptMessage.INVALID_FREQUENCY.getMessage(), PromptMessage.FREQUENCY_OF_DEDUCTION.getMessage(), readInput);

        predictionYear = getValidYear(readInput);

    }

    public static void main(String[] args) {

        //System.out.format("%5s%20s%25s%15s%20s", "Year", "Starting Salary", "Number of Increments", "Increment %", "Increment Amount");
       IncomePredictor predictor = new IncomePredictor();
        List<IncrementReport> incrementReportList = new ArrayList<>();
        List<DeductionReport> deductionReportList = new ArrayList<>();
        List<Prediction> predictionList = new ArrayList<>();

      for(int i=1; i<=predictionYear; i++){
          incrementReportList.add(predictor.generateIncrementReport(i));
          deductionReportList.add(predictor.generateDeductionReport(i));
          predictionList.add(predictor.generatePredictionReport(incrementReportList.get(i-1), deductionReportList.get(i-1),i));
      }

        predictor.printIncrementReport(incrementReportList);
        predictor.printDeductionReport(deductionReportList);
        predictor.printPredictionReport(predictionList);
    }

    public void printHeader(String header1, String header2, String header3, String header4, String header5){
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.format("%5s%20s%25s%15s%20s", header1, header2, header3, header4, header5);
    }

    public void printData(int header1, Double header2, int header3, Double header4, Double header5){
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.format("%5d%20f%25d%15f%20f", header1, header2, header3, header4, header5);
        //System.out.println("--------------------------------------------------------------------");
    }

    public void printPrediction(int header1, Double header2, Double header3, Double header4, Double header5){
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.format("%5d%20f%22f%20f%20f", header1, header2, header3, header4, header5);
        //System.out.println("--------------------------------------------------------------------");
    }

    private void printIncrementReport(List<IncrementReport> incrementReportList) {
        System.out.println("\n a. Increment Report");
        printHeader("Year", "Starting Salary", "Number of Increments", "Increment %", "Increment Amount");
        incrementReportList.forEach(incrementReport -> printData(incrementReport.getYear(),
                incrementReport.getStartingSalary(), incrementReport.getNoOfIncrement(),
                incrementReport.getIncrementPercent(), incrementReport.getIncrementAmount()));
    }

    private void printDeductionReport(List<DeductionReport> deductionReports) {
        System.out.println("\n \n \n b. Deduction Report");
        printHeader("Year", "Starting Salary", "Number of Deductions", "Deduction %", "Deduction Amount");
        deductionReports.forEach(deductionReport -> printData(deductionReport.getYear(),
                deductionReport.getStartingSalary(), deductionReport.getNoOfDeduction(),
                deductionReport.getDeductionPercent(), deductionReport.getDeductionAmount()));
    }

    private void printPredictionReport(List<Prediction> deductionReports) {
        System.out.println("\n \n \n c. Prediction");
        printHeader("Year", "Starting Salary", "Increment Amount", "Deduction Amount", "Salary Growth");
        deductionReports.forEach(predictionReport -> printPrediction(predictionReport.getYear(),
                predictionReport.getStartingSalary(), predictionReport.getIncrementAmount(),
                predictionReport.getDeductionAmount(), predictionReport.getSalaryGrowth()));
    }

    private Prediction generatePredictionReport(IncrementReport incrementReport, DeductionReport deductionReport, int i) {
        Prediction prediction = new Prediction();
        prediction.setYear(i);
        prediction.setStartingSalary(incrementReport.getStartingSalary());
        prediction.setIncrementAmount(incrementReport.getIncrementAmount());
        prediction.setDeductionAmount(deductionReport.getDeductionAmount());
        prediction.setSalaryGrowth(incrementReport.getIncrementAmount() - deductionReport.getDeductionAmount());
        return prediction;
    }

    private DeductionReport generateDeductionReport(int i) {
        DeductionReport deductionReport = new DeductionReport();
        deductionReport.setYear(i);
        deductionReport.setStartingSalary(deductionSalary==0.0 ? salary : deductionSalary);
        deductionReport.setNoOfDeduction(getNoOfIncrementOrDeduction(deductionFrequency));
        deductionReport.setDeductionPercent(deduction);
        deductionReport.setDeductionAmount(getDeductionAmount());
        return deductionReport;
    }

    private IncrementReport generateIncrementReport(int i) {
        IncrementReport incrementReport = new IncrementReport();
        incrementReport.setYear(i);
        incrementReport.setStartingSalary(incrementSalary == 0.0? salary : incrementSalary);
        incrementReport.setNoOfIncrement(getNoOfIncrementOrDeduction(incrementFrequency));
        incrementReport.setIncrementPercent(increment);
        incrementReport.setIncrementAmount(getIncrementAmount());
        return incrementReport;
    }

    public Double getDeductionAmount() {
        int dedutionFrq = getNoOfIncrementOrDeduction(incrementFrequency);
        Double amount = deductionSalary == 0.0 ? salary: deductionSalary;
        Double decrementAmount = amount * (deduction/(dedutionFrq*100)) * dedutionFrq ;
        deductionSalary = amount - decrementAmount;
        return decrementAmount;
    }

    private static Double getIncrementAmount(){
        int incFrq = getNoOfIncrementOrDeduction(incrementFrequency);
        Double amount = incrementSalary == 0.0 ? salary: incrementSalary;
        Double incrementAmount = amount * (increment/(incFrq*100)) * incFrq ;
        incrementSalary = amount + incrementAmount;
        return incrementAmount;
    }

    private static int getNoOfIncrementOrDeduction(Double frequency){
        if(frequency.intValue()== FrequencyWeight.ANNUAL.getFrequency())
            return FrequencyWeight.ONE.getFrequency();
        else if (frequency.intValue()== FrequencyWeight.HALF_YEAR.getFrequency())
            return FrequencyWeight.TWO.getFrequency();
        else
            return FrequencyWeight.FOUR.getFrequency();
    }

    private static int getValidYear(Scanner readInput) {
        System.out.println("Enter valid year to compute the prediction");
        String data = readInput.nextLine();
        try{
            return Integer.parseInt(data);
        }catch(Exception exp){
            exp.printStackTrace();
            System.out.println("Invalid Year entered. So default year 5 picked for the prediction");
            return 5;
        }
    }




    private static Double validateData(String invalidData, String prompt,Scanner readInput){
        System.out.println(prompt);
        String data = readInput.nextLine();
            try {
                Double d = Double.parseDouble(data);
                while(Double.parseDouble(data)< 1){
                    System.out.println(invalidData);
                    System.out.println(prompt);
                    data = readInput.nextLine();
                }
                return d;

            }catch(NumberFormatException exp){
                exp.printStackTrace();
            }
        return 0.0;
    }


}
