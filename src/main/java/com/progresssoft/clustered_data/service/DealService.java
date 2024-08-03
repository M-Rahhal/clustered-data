package com.progresssoft.clustered_data.service;


import com.progresssoft.clustered_data.entity.Deal;
import com.progresssoft.clustered_data.repo.DealRepository;
import com.progresssoft.clustered_data.request.DealRequest;
import com.progresssoft.clustered_data.utils.CurrencyCode;
import com.progresssoft.clustered_data.utils.GlobalDateFormatter;
import org.springframework.stereotype.Service;

@Service
public class DealService {


    private final DealRepository dealRepository;

    public DealService(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    public boolean saveDeal(DealRequest request){
        Deal deal = Deal.builder()
                .id(request.dealId())
                .toCurrency(CurrencyCode.fromString(request.toCurrency()))
                .fromCurrency(CurrencyCode.fromString(request.fromCurrency()))
                .dealTimestamp(GlobalDateFormatter.format(request.dealTimeStamp()))
                .dealAmount(request.dealAmount()).build();

        try {
            Deal savedDeal = dealRepository.save(deal);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
