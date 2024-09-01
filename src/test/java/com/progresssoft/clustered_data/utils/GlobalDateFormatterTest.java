package com.progresssoft.clustered_data.utils;

import com.progresssoft.clustered_data.validator.TimeStampValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class GlobalDateFormatterTest {

    @Test
    public void whenTimeStampIsValid_thenFormatSucceeds() {
        assertNotNull(GlobalDateFormatter.format("2023-07-19T13:45:30"));
        assertNotNull(GlobalDateFormatter.format("2023-07-19 13:45:30"));
        assertNotNull(GlobalDateFormatter.format("19/07/2023 13:45:30"));
        assertNotNull(GlobalDateFormatter.format("07-19-2023 13:45"));
        assertNotNull(GlobalDateFormatter.format("2023/07/19 13:45:30"));
        assertNotNull(GlobalDateFormatter.format("Wed, Jul 19 2023 13:45:30"));
    }

    @Test
    public void whenTimeStampIsInvalid_thenFormatFails() {
        assertThrows(DateTimeParseException.class , () -> GlobalDateFormatter.format("2023-07-19"));        // Missing time
        assertThrows(DateTimeParseException.class , () -> GlobalDateFormatter.format("13:45:30"));          // Missing date
        assertThrows(DateTimeParseException.class , () -> GlobalDateFormatter.format("07-19-2023"));        // Missing time
        assertThrows(DateTimeParseException.class , () -> GlobalDateFormatter.format("19/07/2023"));        // Missing time
        assertThrows(DateTimeParseException.class , () -> GlobalDateFormatter.format("InvalidDateTime"));   // Completely invalid
        assertThrows(DateTimeParseException.class , () -> GlobalDateFormatter.format(null));   // Completely invalid

    }


}