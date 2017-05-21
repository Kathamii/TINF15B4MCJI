package com.factracing.validation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberValidatorTest {

    public static final int MIN = 3;
    public static final int MAX = 8;
    NumberValidator validator;

    @Before
    public void setup() {
        validator = new NumberValidator(MIN, MAX);
    }

    @Test
    public void validateCorrect() throws Exception {
        assertEquals(MIN, (int) validator.validate(MIN));
        assertEquals(MAX, (int) validator.validate(MAX));
    }

    @Test
    public void validateIncorrect() throws Exception {
        assertNull(validator.validate(MIN - 1));
        assertNull(validator.validate(MAX + 1));
    }

}