package com.progresssoft.clustered_data.validator.annotation;

import com.progresssoft.clustered_data.validator.TimeStampValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TimeStampValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTimeStamp {
    String message() default "Invalid time stamp";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
