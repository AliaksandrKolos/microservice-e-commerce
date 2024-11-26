package com.kolos.paymentservice.service;

import com.kolos.paymentservice.service.dto.PaymentNotificationRequest;

public interface MessagePublisher {

    void sendNotification(PaymentNotificationRequest request);
}
