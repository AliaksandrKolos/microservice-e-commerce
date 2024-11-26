package com.kolos.orderservice.service.dto;

import com.kolos.orderservice.data.entity.PaymentMethod;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderResponse {

    private Integer id;
    private String references;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private String customerId;


}
