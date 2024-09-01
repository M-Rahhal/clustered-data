package com.progresssoft.clustered_data.validator;


import com.progresssoft.clustered_data.utils.GlobalDateFormatter;
import com.progresssoft.clustered_data.validator.annotation.ValidTimeStamp;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class TimeStampValidator implements ConstraintValidator<ValidTimeStamp, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try{
            GlobalDateFormatter.format(value);
            return true;
        }catch(DateTimeParseException e){
            return false;
        }
    }

}