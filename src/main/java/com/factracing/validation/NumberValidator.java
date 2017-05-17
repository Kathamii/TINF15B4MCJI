package com.factracing.validation;

/**
 * Created by Janik on 17.05.2017.
 */
public class NumberValidator implements Validator {
    private int min, max;
    NumberValidator(int min, int max){
        this.min = min;
        this.max = max;
    }

    @Override
    public Object validate(Object ob) {
        int number = (int) ob;
        if (number < min || number > max)
            return null;
        return number;
    }
}
