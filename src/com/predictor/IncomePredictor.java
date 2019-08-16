package com.predictor;

import com.predictor.bean.IncomeReport;
import com.predictor.bean.IncrementReport;
import com.predictor.frequency.FrequencyWeight;
import com.predictor.msg.constant.PromptMessage;

import java.util.Scanner;

public class IncomePredictor {

    static Double salary = 0.0;
    static Double increment = 0.0;
    static Double incrementFrequency = 0.0;
    static Double deduction = 0.0;
    static Double deductionFrequency = 0.0;
    static int predictionYear = 0;
    static int currentYear = 2019;

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

       // System.out.format("%32s%10d%16s", "hi", 1, "hello");



        IncomePredictor predictor = new IncomePredictor();
      //  for(int i=1; i<=1; i++)


        System.out.println(generateIncrementReport(1).getIncrementAmount());
    }

    private static IncrementReport generateIncrementReport(int i) {
        IncrementReport incrementReport = new IncrementReport();
        incrementReport.setYear(currentYear+1);
        incrementReport.setStartingSalary(salary);
        incrementReport.setNoOfIncrement(getNoOfIncrement());
        incrementReport.setIncrementPercent(increment.intValue());
        incrementReport.setIncrementAmount(getIncrementAmount());
        return incrementReport;
    }

    private static Double getIncrementAmount(){
        Double incrementAmount = 0.0;
        int incrementFrequency = getNoOfIncrement();
        for(int i =1; i<=incrementFrequency; i++){
            incrementAmount = (salary * increment.intValue()/incrementFrequency)/100;
            salary = salary + incrementAmount;
        }
        return incrementAmount;
    }

    private static int getNoOfIncrement(){
        if(incrementFrequency.intValue()== FrequencyWeight.ANNUAL.getFrequency())
            return FrequencyWeight.ONE.getFrequency();
        else if (incrementFrequency.intValue()== FrequencyWeight.HALF_YEAR.getFrequency())
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
        }
        return 5;
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
