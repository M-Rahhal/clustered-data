package com.progresssoft.clustered_data.controller;

import com.progresssoft.clustered_data.repo.DealRepository;
import com.progresssoft.clustered_data.request.DealRequest;
import com.progresssoft.clustered_data.service.DealService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class DealControllerTest {

    private DealService dealService = Mockito.mock(DealService.class);

    private DealController dealController = new DealController(dealService);

    private DealRequest dealRequest;

    @BeforeEach
    void setUp() {
        dealRequest = new DealRequest(
                1L , "USD", "JOD", Timestamp.from(Instant.now()).toString(), 1.2
        );
    }
    @Test
    void whenRequestUniqueIdIsSentThenStatusIsTrue(){
        Mockito.when(dealService.saveDeal(Mockito.any(DealRequest.class))).thenReturn(true);
        Assertions.assertTrue(dealController.createDeal(dealRequest).getBody().status());
    }

    @Test
    void whenRequestUniqueIdIsSentThenStatusIsFalse(){
        Mockito.when(dealService.saveDeal(Mockito.any(DealRequest.class))).thenReturn(false);
        Assertions.assertFalse(dealController.createDeal(dealRequest).getBody().status());
    }


}