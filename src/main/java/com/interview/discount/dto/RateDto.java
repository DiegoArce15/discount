package com.interview.discount.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@Schema(name = "Rate", description = "Informacion de la tarifa a aplicar")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RateDto {

    @Schema(name = "productId", description = "Identificador de producto")
    private int productId;

    @Schema(name = "brandId", description = "Identificador de cadena")
    private int brandId;

    @Schema(name = "priceRate", description = "Tarifa a aplicar")
    private int priceRate;

    @Schema(name = "startPriceRate", description = "Fecha de inicio de la tarifa de precio")
    private LocalDateTime startPriceRate;

    @Schema(name = "endPriceRate", description = "Fecha de fin de la tarifa de precio")
    private LocalDateTime endPriceRate;

    @Schema(name = "price", description = "Precio final a aplicar")
    private BigDecimal price;
}
