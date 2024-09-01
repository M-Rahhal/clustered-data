package com.progresssoft.clustered_data.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CurrencyValidatorTest {

    private CurrencyValidator currencyValidator;

    @BeforeEach
    public void setUp() {
        currencyValidator = new CurrencyValidator();
    }

    @Test
    public void whenCurrencyCodeIsValid_thenValidationSucceeds() {
        assertTrue(currencyValidator.isValid("USD", null));
        assertTrue(currencyValidator.isValid("EUR", null));
        assertTrue(currencyValidator.isValid("JOD", null));
        assertTrue(currencyValidator.isValid("usd", null));
    }

    @Test
    public void whenCurrencyCodeIsInvalid_thenValidationFails() {
        assertFalse(currencyValidator.isValid("INVALID", null));
        assertFalse(currencyValidator.isValid("", null));
        assertFalse(currencyValidator.isValid(null, null));
    }

    @Test
    public void whenCurrencyCodeIsEmptyOrNull_thenValidationFails() {
        assertFalse(currencyValidator.isValid("", null));
        assertFalse(currencyValidator.isValid(null, null));
    }
}
