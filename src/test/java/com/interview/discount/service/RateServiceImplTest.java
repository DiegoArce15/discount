package com.interview.discount.service;

import com.interview.discount.dto.RateDto;
import com.interview.discount.exception.RateNotFoundException;
import com.interview.discount.model.Price;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class RateServiceImplTest {

    @MockBean
    private PriceService priceService;

    @Autowired
    private RateService rateService;

    @Test
    public void getRateByDateAndBrandIdAndBrandIdGetOne(){
        Price price = new Price();
        price.setPriceId(1L);
        price.setBrandId(1);
        price.setStartDate(LocalDateTime.of(2020, 06, 14, 00, 00, 00));
        price.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        price.setPriceList(1);
        price.setProductId(35455);
        price.setPriority(1);
        price.setPriceDetail(new BigDecimal("30.50"));

        RateDto rateDto = RateDto.builder()
                .productId(35455)
                .brandId(1)
                .priceRate(1)
                .startPriceRate(LocalDateTime.of(2020, 06, 14, 00, 00, 00))
                .endPriceRate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .price(new BigDecimal("30.50"))
                .build();

        Mockito.when(priceService.getPriceByDateAndProductIdAndBrandId(Mockito.any(LocalDateTime.class), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(Optional.of(price));

        RateDto result = rateService.getRateByDateAndProductIdAndBrandId(LocalDateTime.of(2020, 06, 14, 00, 00, 00), 35455, 1);

        assertThat(result).isEqualTo(rateDto);
    }

    @Test
    public void getRateByDateAndBrandIdAndBrandIdGetException(){


        Mockito.when(priceService.getPriceByDateAndProductIdAndBrandId(Mockito.any(LocalDateTime.class), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(Optional.empty());

        RateNotFoundException exception = assertThrows(RateNotFoundException.class, () -> {
            rateService.getRateByDateAndProductIdAndBrandId(LocalDateTime.of(2020, 06, 14, 00, 00, 00), 35455, 1);
        });

        assertThat(exception.getMessage()).isEqualTo("Rate not found");
    }
}
