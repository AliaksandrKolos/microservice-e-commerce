package com.kolos.paymentservice.service.impl;

import com.kolos.paymentservice.data.repository.PaymentRepository;
import com.kolos.paymentservice.service.MessagePublisher;
import com.kolos.paymentservice.service.PaymentMapper;
import com.kolos.paymentservice.service.PaymentService;
import com.kolos.paymentservice.service.dto.PaymentNotificationRequest;
import com.kolos.paymentservice.service.dto.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final MessagePublisher messagePublisher;

    @Override
    @Transactional
    public Integer createPayment(PaymentRequest request) {
        var payment = paymentRepository.save(paymentMapper.toPayment(request));
        messagePublisher.sendNotification(
                new PaymentNotificationRequest(
                        request.getOrderReference(),
                        request.getAmount(),
                        request.getPaymentMethod(),
                        request.getCustomer().getFirstname(),
                        request.getCustomer().getLastname(),
                        request.getCustomer().getEmail()
                )
        );

        return payment.getId();
    }
}
