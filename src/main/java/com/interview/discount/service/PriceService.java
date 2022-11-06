package com.interview.discount.service;

import com.interview.discount.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Interfaz de comunicación con la base de datos PRICE
 *
 * @author Diego
 */
public interface PriceService {

    /**
     * Obtiene de la base de datos la tarifa que se para un producto de la marca marca introducida
     * activa durante la fecha consultada
     *
     * @param applicationDate Fecha a consultar
     * @param productId       Identificador de producto
     * @param brandId         Identificador de la marca
     * @return Tarifa a aplicar
     */
    Optional<Price> getPriceByDateAndProductIdAndBrandId(LocalDateTime applicationDate, int productId, int brandId);

}
