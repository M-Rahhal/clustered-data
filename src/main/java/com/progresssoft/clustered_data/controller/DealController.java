package com.progresssoft.clustered_data.controller;

import com.progresssoft.clustered_data.request.DealRequest;
import com.progresssoft.clustered_data.service.DealService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.progresssoft.clustered_data.response.GeneralResponse;

@RestController
@RequestMapping(path = "/api")
public class DealController {


    private final DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @PostMapping(
            path = "/deals",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<GeneralResponse> createDeal(@Valid @RequestBody DealRequest dealRequest) {

        boolean status = dealService.saveDeal(dealRequest);

        if (status){
            return new ResponseEntity<>(GeneralResponse.builder()
                    .status(true)
                    .message("Deal created successfully!")
                    .data(null).build() , HttpStatus.CREATED);
        }

        else return new ResponseEntity<>(GeneralResponse.builder()
                .status(false)
                .message("Something went wrong!")
                .data(null).build() , HttpStatus.BAD_REQUEST);

    }
}