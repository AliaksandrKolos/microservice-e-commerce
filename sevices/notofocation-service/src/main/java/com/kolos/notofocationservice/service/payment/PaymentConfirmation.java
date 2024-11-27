package com.kolos.notofocationservice.service.payment;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentConfirmation {

    private String orderReference;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private String customerFirstname;
    private String customerLastname;
    private String customerEmail;
}
