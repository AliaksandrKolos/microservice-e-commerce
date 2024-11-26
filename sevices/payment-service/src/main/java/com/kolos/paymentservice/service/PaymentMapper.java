package com.kolos.paymentservice.service;

import com.kolos.paymentservice.data.entity.Payment;
import com.kolos.paymentservice.service.dto.PaymentRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {


    Payment toPayment(PaymentRequest request);
}
