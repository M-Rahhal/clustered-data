package com.progresssoft.clustered_data.utils;

public enum CurrencyCode {
    USD, EUR, JPY, GBP, AUD, CAD, CHF, CNY, SEK, NZD, JOD;

    public static CurrencyCode fromString(String code) throws IllegalArgumentException {
        for (CurrencyCode currencyCode : CurrencyCode.values()) {
            if (currencyCode.name().equalsIgnoreCase(code)) {
                return currencyCode;
            }
        }
        throw new IllegalArgumentException("The currency requested is not available");
    }
}
