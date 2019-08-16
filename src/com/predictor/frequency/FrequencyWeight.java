package com.predictor.frequency;

public enum FrequencyWeight {
    ONE (1),
    TWO (2),
    THREE (3),
    FOUR (4),
    QUARTER(FOUR.getFrequency()),
    HALF_YEAR(TWO.getFrequency()),
    ANNUAL (ONE.getFrequency());

    int frequency = 0;
    FrequencyWeight(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency(){
        return frequency;
    }
}
