package com.progresssoft.clustered_data.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class GlobalDateFormatter {
    private static final DateTimeFormatter[] FORMATTERS = {
            DateTimeFormatter.ISO_LOCAL_DATE_TIME,
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"),
            DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm"),
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"),
            DateTimeFormatter.ofPattern("EEE, MMM d yyyy HH:mm:ss"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
    };


    public static LocalDateTime format(String dateAsString){
        for (DateTimeFormatter formatter: FORMATTERS){
            try{
                return LocalDateTime.parse(dateAsString , formatter);
            }catch(DateTimeParseException e){}
        }
        throw new IllegalArgumentException("The date provided is not accepted!");
    }
}
