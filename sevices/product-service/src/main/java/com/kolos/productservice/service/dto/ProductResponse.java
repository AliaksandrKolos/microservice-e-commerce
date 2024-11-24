package com.kolos.productservice.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {

    private Integer id;
    private String name;
    private String description;
    private double availableQuantity;
    private BigDecimal price;
    private Integer categoryId;
    private String categoryName;
    private String categoryDescription;
}
