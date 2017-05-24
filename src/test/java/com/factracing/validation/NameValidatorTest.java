package com.factracing.validation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameValidatorTest {
    public static final String CORRECT = "Something";
    public static final CharSequence[] INVALID_CHARS = {"@", "!"};
    NameValidator validator;

    @Before
    public void setUp() throws Exception{
        validator = new NameValidator(INVALID_CHARS);
    }

    @Test
    public void validateCorrect() throws Exception {
        assertEquals(CORRECT, validator.validate(CORRECT));
    }

    @Test
    public void validateIncorrect() throws Exception {
        for(CharSequence invalid: INVALID_CHARS) {
            assertNull(validator.validate(CORRECT + invalid.toString()));
        }
    }
}