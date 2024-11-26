package com.kolos.paymentservice.service;

import com.kolos.paymentservice.service.dto.PaymentRequest;

public interface PaymentService {
    Integer createPayment(PaymentRequest request);
}
