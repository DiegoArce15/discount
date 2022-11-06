package com.interview.discount.service;

import com.interview.discount.dto.RateDto;
import com.interview.discount.exception.RateNotFoundException;
import com.interview.discount.model.Price;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RateServiceImpl implements RateService {

    private final PriceService priceService;

    @Override
    public RateDto getRateByDateAndBrandIdAndBrandId(LocalDateTime applicationDate, int productId, int brandId) {

        Optional<Price> price = priceService.getPriceByDateAndProductIdAndBrandId(applicationDate, productId, brandId);

        log.info("Tarifa recuperada de la base de datos {}", price);

        return price.map(value -> RateDto.builder()
                        .productId(value.getProductId())
                        .brandId(value.getBrandId())
                        .priceRate(value.getPriceList())
                        .startPriceRate(value.getStartDate())
                        .endPriceRate(value.getEndDate())
                        .price(value.getPriceDetail())
                        .build())
                .orElseThrow(() -> new RateNotFoundException("Rate not found"));

    }
}

