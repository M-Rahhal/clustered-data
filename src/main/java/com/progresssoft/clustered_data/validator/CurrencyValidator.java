package com.progresssoft.clustered_data.validator;

import com.progresssoft.clustered_data.utils.CurrencyCode;
import com.progresssoft.clustered_data.validator.annotation.Currency;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class CurrencyValidator implements ConstraintValidator<Currency, String> {
    @Override
    public boolean isValid(String currencyCode, ConstraintValidatorContext constraintValidatorContext) {
        if (currencyCode == null || currencyCode.isEmpty())
            return false;
        return Arrays.stream(CurrencyCode.values()).anyMatch(code -> code.name().equals(currencyCode.toUpperCase()));
    }
}
