package com.progresssoft.clustered_data.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CurrencyCodeTest {


    @Test
    void whenPassingInvalidCurrencyItThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CurrencyCode.fromString("invalid");
        });
    }

    @Test
    void whenPassingValidCurrencyItReturnsCurrencyCode() {
        Assertions.assertEquals(CurrencyCode.USD, CurrencyCode.fromString("USD"));
        Assertions.assertEquals(CurrencyCode.AUD, CurrencyCode.fromString("AUD"));
        Assertions.assertEquals(CurrencyCode.CHF, CurrencyCode.fromString("ChF"));
    }
}