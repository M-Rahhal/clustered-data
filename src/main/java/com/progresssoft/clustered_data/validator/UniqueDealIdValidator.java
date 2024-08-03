package com.progresssoft.clustered_data.validator;

import com.progresssoft.clustered_data.repo.DealRepository;
import com.progresssoft.clustered_data.validator.annotation.UniqueDealId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
public class UniqueDealIdValidator implements ConstraintValidator<UniqueDealId, Long> {


    @Autowired
    private DealRepository dealRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {

        if (id == null)
            return false;
        return !dealRepository.existsById(id);
    }
}