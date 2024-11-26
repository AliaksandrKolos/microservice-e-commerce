package com.kolos.paymentservice.service.dto;

import com.kolos.paymentservice.data.entity.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PaymentNotificationRequest {

    private String orderReference;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private String customerFirstname;
    private String customerLastname;
    private String customerEmail;
}
