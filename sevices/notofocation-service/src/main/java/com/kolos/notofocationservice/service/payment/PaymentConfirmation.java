package com.kolos.notofocationservice.service.payment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonCreator
    public PaymentConfirmation(
            @JsonProperty("orderReference") String orderReference,
            @JsonProperty("amount") BigDecimal amount,
            @JsonProperty("paymentMethod") PaymentMethod paymentMethod,
            @JsonProperty("customerFirstname") String customerFirstname,
            @JsonProperty("customerLastname") String customerLastname,
            @JsonProperty("customerEmail") String customerEmail
    ) {
        this.orderReference = orderReference;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.customerFirstname = customerFirstname;
        this.customerLastname = customerLastname;
        this.customerEmail = customerEmail;
    }
}
