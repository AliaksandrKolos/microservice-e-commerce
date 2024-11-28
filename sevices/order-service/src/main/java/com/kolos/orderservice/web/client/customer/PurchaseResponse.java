package com.kolos.orderservice.web.client.customer;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PurchaseResponse implements Serializable {

    private Integer productId;
    private String name;
    private String description;
    private BigDecimal price;
    private double quantity;
}
