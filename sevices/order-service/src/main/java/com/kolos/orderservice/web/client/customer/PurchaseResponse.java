package com.kolos.orderservice.web.client.customer;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PurchaseResponse {

    private Integer productId;
    private String name;
    private String description;
    private BigDecimal price;
    private double quantity;
}
