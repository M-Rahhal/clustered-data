package com.progresssoft.clustered_data.service;

import com.progresssoft.clustered_data.entity.Deal;
import com.progresssoft.clustered_data.repo.DealRepository;
import com.progresssoft.clustered_data.request.DealRequest;
import com.progresssoft.clustered_data.utils.CurrencyCode;
import com.progresssoft.clustered_data.utils.GlobalDateFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DealServiceTest {

    @Mock
    private DealRepository dealRepository;

    @InjectMocks
    private DealService dealService;

    private DealRequest validDealRequest;
    private Deal deal;

    @BeforeEach
    void setUp() {
        validDealRequest = new DealRequest(
                1L, "USD", "EUR", "2024-08-03T12:00:00", 1000.0
        );

        deal = Deal.builder()
                .id(validDealRequest.dealId())
                .toCurrency(CurrencyCode.fromString(validDealRequest.toCurrency()))
                .fromCurrency(CurrencyCode.fromString(validDealRequest.fromCurrency()))
                .dealTimestamp(GlobalDateFormatter.format(validDealRequest.dealTimeStamp()))
                .dealAmount(validDealRequest.dealAmount())
                .build();
    }

    @Test
    void whenDealSavedSuccessfully_thenReturnTrue() {
        when(dealRepository.save(any(Deal.class))).thenReturn(deal);

        boolean result = dealService.saveDeal(validDealRequest);

        assertTrue(result);
    }

    @Test
    void whenDealSaveFails_thenReturnFalse() {
        when(dealRepository.save(any(Deal.class))).thenThrow(IllegalArgumentException.class);

        boolean result = dealService.saveDeal(validDealRequest);

        assertFalse(result);
    }
}