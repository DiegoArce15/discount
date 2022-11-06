package com.interview.discount.service;

import com.interview.discount.model.Price;
import com.interview.discount.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PriceServiceImplTest {

    @Autowired
    private PriceService priceService;

    @MockBean
    private PriceRepository priceRepository;

    @Test
    public void getPriceByDateAndProductIdAndBrandIdGetOne() {
        Price price = new Price();
        price.setPriceId(1L);
        price.setBrandId(1);
        price.setStartDate(LocalDateTime.of(2020, 06, 14, 00, 00, 00));
        price.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        price.setPriceList(1);
        price.setProductId(35455);
        price.setPriority(1);
        price.setPriceDetail(new BigDecimal("12.13"));

        Mockito.when(priceRepository.findFirstPriceBetweenStartDateAndEndDateAndProductIdAndBrandId(Mockito.any(LocalDateTime.class), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(Optional.of(price));

        Optional<Price> result = priceService.getPriceByDateAndProductIdAndBrandId( LocalDateTime.of(2020, 06, 15, 00, 00, 00),1 ,1);

        assertThat(result).isEqualTo(Optional.of(price));
    }

    @Test
    public void getPriceByDateAndProductIdAndBrandIdNotFound() {
        Mockito.when(priceRepository.findFirstPriceBetweenStartDateAndEndDateAndProductIdAndBrandId(Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(Optional.empty());

        Optional<Price> result = priceService.getPriceByDateAndProductIdAndBrandId( LocalDateTime.of(2020, 06, 15, 00, 00, 00),1 ,1);

        assertThat(result).isEmpty();
    }

}
