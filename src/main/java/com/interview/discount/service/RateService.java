package com.interview.discount.service;


import com.interview.discount.dto.RateDto;

import java.time.LocalDateTime;

public interface RateService {

    /**
     * Obtiene la tarifa a aplicar para un producto de la cadena dado una fecha.
     *
     * @param applicationDate Fecha de la tarifa activa
     * @param productId       Identificador de producto
     * @param brandId         Identificador de cadena
     * @return Tarifa a aplicar
     */
    RateDto getRateByDateAndProductIdAndBrandId(LocalDateTime applicationDate, int productId, int brandId);
}
