package com.progresssoft.clustered_data.response;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;


@Builder
public record GeneralResponse(
        @JsonProperty("status") boolean status,
        @JsonProperty("message") String message,
        @JsonProperty("data") Object data
) {
}
