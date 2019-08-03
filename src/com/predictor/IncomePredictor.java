package com.predictor;

import com.predictor.msg.constant.PromptMessage;

import java.util.Scanner;

public class IncomePredictor {

    public static void main(String[] args) {

        System.out.format("%32s%10d%16s", "hi", 1, "hello");

        /*Scanner readInput = new Scanner(System.in);

        Double salary = validateData(readInput.nextLine(),
                PromptMessage.INVALID_SALARY.getMessage(), PromptMessage.ENTER_START_SALARY.getMessage(), readInput);

        Double increment = validateData(readInput.nextLine(),
                PromptMessage.INVALID_INCREMENT.getMessage(), PromptMessage.ENTER_INCREMENT_TO_RECEIVE.getMessage(), readInput);

        Double incrementFrequency = validateData(readInput.nextLine(),
                PromptMessage.INVALID_FREQUENCY.getMessage(), PromptMessage.FREQUENCY_OF_INCREMENT.getMessage(), readInput);

        Double deduction = validateData(readInput.nextLine(),
                PromptMessage.INVALID_DEDUCTION.getMessage(), PromptMessage.DEDUCTION_OF_INCOME.getMessage(), readInput);

        Double deductionFrequency = validateData(readInput.nextLine(),
                PromptMessage.INVALID_FREQUENCY.getMessage(), PromptMessage.FREQUENCY_OF_DEDUCTION.getMessage(), readInput);

        Double predictionYear = validateData(readInput.nextLine(),
                PromptMessage.INVALID_PREDICTION_FOR_YEARS.getMessage(), PromptMessage.PREDICTION_FOR_YEARS.getMessage(), readInput);*/
    }



    private static Double validateData(String data, String invalidData, String prompt,Scanner readInput){
        System.out.println(prompt);
        if(data!=null){
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
        }
        return 0.0;
    }
}
