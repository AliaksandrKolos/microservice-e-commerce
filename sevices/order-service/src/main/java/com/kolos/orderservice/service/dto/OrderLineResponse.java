package com.kolos.orderservice.service.dto;

import lombok.Data;

@Data
public class OrderLineResponse {

    private Integer id;
    double quantity;
}
