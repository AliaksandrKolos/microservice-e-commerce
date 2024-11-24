package com.kolos.productservice.service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductPurchaseRequest {

    @NotNull(message = "Product is mandatory")
    private Integer productId;
    @Positive(message = "Quantity is mandatory")
    private double quantity;
}
