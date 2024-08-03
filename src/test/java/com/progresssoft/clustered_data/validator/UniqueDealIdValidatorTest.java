package com.progresssoft.clustered_data.validator;

import com.progresssoft.clustered_data.repo.DealRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UniqueDealIdValidatorTest {

    @Mock
    private DealRepository dealRepository;

    @InjectMocks
    private UniqueDealIdValidator uniqueDealIdValidator;

    @BeforeEach
    public void setUp() {
        uniqueDealIdValidator = new UniqueDealIdValidator();
        uniqueDealIdValidator.setDealRepository(dealRepository);
    }

    @Test
    public void whenIdIsUnique_thenValidationSucceeds() {
        Long uniqueId = 1L;
        when(dealRepository.existsById(uniqueId)).thenReturn(false);

        boolean isValid = uniqueDealIdValidator.isValid(uniqueId, null);
        assertTrue(isValid);
    }

    @Test
    public void whenIdIsNotUnique_thenValidationFails() {
        Long existingId = 1L;
        when(dealRepository.existsById(existingId)).thenReturn(true);

        boolean isValid = uniqueDealIdValidator.isValid(existingId, null);
        assertFalse(isValid);
    }

    @Test
    public void whenIdIsNull_thenValidationFails() {
        boolean isValid = uniqueDealIdValidator.isValid(null, null);
        assertFalse(isValid);
    }
}