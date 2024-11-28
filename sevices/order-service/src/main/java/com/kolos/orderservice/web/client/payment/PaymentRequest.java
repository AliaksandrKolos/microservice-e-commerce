package com.kolos.orderservice.web.client.payment;

import com.kolos.orderservice.data.entity.PaymentMethod;
import com.kolos.orderservice.web.client.customer.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PaymentRequest implements Serializable {

    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private Integer orderId;
    private String orderReference;
    private CustomerResponse customer;

}
