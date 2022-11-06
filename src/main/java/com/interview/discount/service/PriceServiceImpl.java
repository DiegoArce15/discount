package com.interview.discount.service;

import com.interview.discount.model.Price;
import com.interview.discount.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    @Override
    public Optional<Price> getPriceByDateAndProductIdAndBrandId(LocalDateTime applicationDate, int productId, int brandId) {
        log.info("Obtener tarifa de precios para el producto {} de la marca {} a partir de la fecha {} de la base de datos",
                productId, brandId, applicationDate);

        return priceRepository.findFirstPriceBetweenStartDateAndEndDateAndProductIdAndBrandId(applicationDate, productId, brandId);
    }
}
