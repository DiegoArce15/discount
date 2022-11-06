package com.interview.discount.endpoint.api;

import com.interview.discount.dto.RateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Tag(name = "Rates")
public interface DiscountApi {

    @Operation(summary = "Obtiene la tarifa a aplicar durante la fecha para el producto y marca introducidos",
            responses = {
                    @ApiResponse(content = @Content(mediaType = "application/json", schema = @Schema(implementation = RateDto.class))),
                    @ApiResponse(responseCode = "404", description = "Rate not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    ResponseEntity<RateDto> getPrices(@Parameter(description = "Fecha de en la que buscar la tarifa", required = true, example = "2020-01-01 12:00:00") LocalDateTime applicationDate,
                                      @Parameter(description = "Id del producto del cual buscar la tarifa", example = "11111", required = true) int productId,
                                      @Parameter(description = "Id de la cadena", example = "1", required = true) int brandId);

}
