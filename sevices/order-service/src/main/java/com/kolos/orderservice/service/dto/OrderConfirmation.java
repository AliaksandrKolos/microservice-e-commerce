package com.kolos.orderservice.service.dto;

import com.kolos.orderservice.data.entity.PaymentMethod;
import com.kolos.orderservice.web.client.customer.CustomerResponse;
import com.kolos.orderservice.web.client.customer.PurchaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderConfirmation {

    private String orderReference;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private CustomerResponse customer;
    private List<PurchaseResponse> products;

}
