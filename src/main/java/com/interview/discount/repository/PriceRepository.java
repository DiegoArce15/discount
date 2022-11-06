package com.interview.discount.repository;

import com.interview.discount.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query(value="SELECT * " +
            "FROM PRICES price " +
            "WHERE :fecha BETWEEN price.START_DATE AND price.END_DATE "+
            "AND price.PRODUCT_ID = :productId " +
            "AND price.BRAND_ID = :brandId " +
            "ORDER BY price.PRIORITY DESC LIMIT 1", nativeQuery = true)
    Optional<Price> findFirstPriceBetweenStartDateAndEndDateAndProductIdAndBrandId(LocalDateTime fecha, int productId, int brandId);
}
