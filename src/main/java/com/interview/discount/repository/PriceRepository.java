package com.interview.discount.repository;

import com.interview.discount.model.Price;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PriceRepository extends PagingAndSortingRepository<Price, Long> {
}
