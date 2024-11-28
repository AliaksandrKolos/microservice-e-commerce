package com.kolos.paymentservice.service.impl;

import com.kolos.paymentservice.service.MessagePublisher;
import com.kolos.paymentservice.service.dto.PaymentNotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessagePublisherImpl implements MessagePublisher {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.direct}")
    private String directExchangeName;


    @Value("${rabbitmq.routing-key.payment-notification}")
    private String paymentNotificationRoutingKey;



    @Override
    public void sendNotification(PaymentNotificationRequest request) {
        log.info("Sending notification with body <{}>", request);
        rabbitTemplate.convertAndSend(directExchangeName, paymentNotificationRoutingKey, request);
    }


}
