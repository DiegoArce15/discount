package com.interview.discount.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DiscountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
     */
    @Test
    void getRateForDay14At10AndBrand1AndProduct35455() throws Exception {
        String expected = "{" +
                "  \"productId\": 35455," +
                "  \"brandId\": 1," +
                "  \"priceRate\": 1," +
                "  \"startPriceRate\": \"2020-06-14T00:00:00\"," +
                "  \"endPriceRate\": \"2020-12-31T23:59:59\"," +
                "  \"price\": 35.5" +
                "}";

        mockMvc.perform(get("/api/v1.0/rates")
                        .queryParam("applicationDate", "2020-06-14 10:00:00")
                        .queryParam("productId", "35455")
                        .queryParam("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andReturn();
    }

    /**
     * Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
     */
    @Test
    void getRateForDay14At16AndBrand1AndProduct35455() throws Exception {
        String expected = "{" +
                "  \"productId\": 35455," +
                "  \"brandId\": 1," +
                "  \"priceRate\": 2," +
                "  \"startPriceRate\": \"2020-06-14T15:00:00\"," +
                "  \"endPriceRate\": \"2020-06-14T18:30:00\"," +
                "  \"price\": 25.45" +
                "}";

        mockMvc.perform(get("/api/v1.0/rates")
                        .queryParam("applicationDate", "2020-06-14 16:00:00")
                        .queryParam("productId", "35455")
                        .queryParam("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andReturn();
    }

    /**
     * Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
     */
    @Test
    void getRateForDay14At21AndBrand1AndProduct35455() throws Exception {
        String expected = "{" +
                "  \"productId\": 35455," +
                "  \"brandId\": 1," +
                "  \"priceRate\": 1," +
                "  \"startPriceRate\": \"2020-06-14T00:00:00\"," +
                "  \"endPriceRate\": \"2020-12-31T23:59:59\"," +
                "  \"price\": 35.5" +
                "}";

        mockMvc.perform(get("/api/v1.0/rates")
                        .queryParam("applicationDate", "2020-06-14 21:00:00")
                        .queryParam("productId", "35455")
                        .queryParam("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andReturn();
    }

    /**
     * Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
     */
    @Test
    void getRateForDay15At10AndBrand1AndProduct35455() throws Exception {
        String expected = "{" +
                "  \"productId\": 35455," +
                "  \"brandId\": 1," +
                "  \"priceRate\": 3," +
                "  \"startPriceRate\": \"2020-06-15T00:00:00\"," +
                "  \"endPriceRate\": \"2020-06-15T11:00:00\"," +
                "  \"price\": 30.5" +
                "}";

        mockMvc.perform(get("/api/v1.0/rates")
                        .queryParam("applicationDate", "2020-06-15 10:00:00")
                        .queryParam("productId", "35455")
                        .queryParam("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andReturn();
    }

    /**
     * Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
     */
    @Test
    void getRateForDay15At21AndBrand1AndProduct35455() throws Exception {
        String expected = "{" +
                "  \"productId\": 35455," +
                "  \"brandId\": 1," +
                "  \"priceRate\": 4," +
                "  \"startPriceRate\": \"2020-06-15T16:00:00\"," +
                "  \"endPriceRate\": \"2020-12-31T23:59:59\"," +
                "  \"price\": 38.95" +
                "}";

        mockMvc.perform(get("/api/v1.0/rates")
                        .queryParam("applicationDate", "2020-06-15 21:00:00")
                        .queryParam("productId", "35455")
                        .queryParam("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andReturn();
    }
}
