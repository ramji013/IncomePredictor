package com.predictor.msg.constant;

public enum PromptMessage {
    ENTER_START_SALARY("Please enter starting salary : "),
    INVALID_SALARY("Please enter valid starting salary"),
    ENTER_INCREMENT_TO_RECEIVE("Please enter increment to be received in percent : "),
    INVALID_INCREMENT("Please enter valid increment : "),
    FREQUENCY_OF_INCREMENT("How frequently increment received : \n 1. quarterly \n 2. half-yearly \n 3. annually \n select an option : "),
    INVALID_FREQUENCY("Please enter valid frequency : "),
    DEDUCTION_OF_INCOME("Please enter deductions in percent : "),
    INVALID_DEDUCTION("Please enter valid deduction : "),
    FREQUENCY_OF_DEDUCTION("How frequently the deduction applied: \n 1. quarterly \n 2. half-yearly \n 3. annually \n select an option : "),
    PREDICTION_FOR_YEARS("Please enter the predictiom years. For example, 5, 10, 15 (Note the number is in years) "),
    INVALID_PREDICTION_FOR_YEARS("Please enter the valid predictiom year.");

    private String message;

    PromptMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PromptMessage{" +
                "message='" + message + '\'' +
                '}';
    }
    public String getMessage(){
        return message;
    }
}
