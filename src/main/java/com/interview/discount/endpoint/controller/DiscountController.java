package com.interview.discount.endpoint.controller;

import com.interview.discount.dto.RateDto;
import com.interview.discount.endpoint.api.DiscountApi;
import com.interview.discount.service.RateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1.0")
public class DiscountController implements DiscountApi {

    private final RateService rateService;

    @Override
    @GetMapping("/rates")
    public ResponseEntity<RateDto> getPrices(@RequestParam("applicationDate") LocalDateTime applicationDate,
                                             @RequestParam int productId,
                                             @RequestParam int brandId) {
        log.info("Obteniendo la tarifa para la fecha {}, el producto {} y la marca {}", applicationDate, productId, brandId);

        RateDto rateDto = rateService.getRateByDateAndProductIdAndBrandId(applicationDate, productId, brandId);

        return ResponseEntity.ok(rateDto);
    }
}
