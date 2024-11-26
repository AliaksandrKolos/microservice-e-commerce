package com.kolos.orderservice.service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PurchaseRequest {

    @NotNull(message = "Product is mandatory")
    private Integer productId;
    @Positive(message = "Quantity is mandatory")
    private double quantity;
}
