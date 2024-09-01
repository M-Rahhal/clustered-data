package com.progresssoft.clustered_data.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class TimeStampValidatorTest {

    private TimeStampValidator timeStampValidator;

    @BeforeEach
    public void setUp() {
        timeStampValidator = new TimeStampValidator();
    }

    @Test
    public void whenTimeStampIsValid_thenValidationSucceeds() {
        assertTrue(timeStampValidator.isValid("2023-07-19T13:45:30", null));
        assertTrue(timeStampValidator.isValid("2023-07-19 13:45:30", null));
        assertTrue(timeStampValidator.isValid("19/07/2023 13:45:30", null));
        assertTrue(timeStampValidator.isValid("07-19-2023 13:45", null));
        assertTrue(timeStampValidator.isValid("2023/07/19 13:45:30", null));
        assertTrue(timeStampValidator.isValid("Wed, Jul 19 2023 13:45:30", null));
    }

    @Test
    public void whenTimeStampIsInvalid_thenValidationFails() {
        assertFalse(timeStampValidator.isValid("2023-07-19", null)); // Missing time
        assertFalse(timeStampValidator.isValid("13:45:30", null)); // Missing date
        assertFalse(timeStampValidator.isValid("07-19-2023", null)); // Missing time
        assertFalse(timeStampValidator.isValid("19/07/2023", null)); // Missing time
        assertFalse(timeStampValidator.isValid("InvalidDateTime", null)); // Completely invalid
    }

    @Test
    public void whenTimeStampIsEmptyOrNull_thenValidationFails() {
        assertFalse(timeStampValidator.isValid("", null));
    }
}