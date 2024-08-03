package com.progresssoft.clustered_data.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.progresssoft.clustered_data.validator.annotation.Currency;
import com.progresssoft.clustered_data.validator.annotation.UniqueDealId;
import com.progresssoft.clustered_data.validator.annotation.ValidTimeStamp;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DealRequest(

        @JsonProperty("deal-id") @UniqueDealId @NotNull Long dealId,
        @JsonProperty("from-currency") @Currency @NotNull String fromCurrency,
        @JsonProperty("to-currency") @Currency @NotNull String toCurrency,
        @JsonProperty("deal-time-stamp") @ValidTimeStamp @NotNull String dealTimeStamp,
        @JsonProperty("deal-amount") @Positive @NotNull Double dealAmount
) {
}
