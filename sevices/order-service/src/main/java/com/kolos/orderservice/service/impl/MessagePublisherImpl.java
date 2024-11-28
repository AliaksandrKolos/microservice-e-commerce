package com.kolos.orderservice.service.impl;

import com.kolos.orderservice.service.dto.OrderConfirmation;
import com.kolos.orderservice.service.MessagePublisher;
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

    @Value("${rabbitmq.routing-key.order-confirmation}")
    private String orderConfirmationRoutingKey;

    @Value("${rabbitmq.exchange.direct}")
    private String directExchangeName;

    @Override
    public void sendOrderConfirmation(OrderConfirmation orderConfirmation) {
        log.info("Sending order confirmation");
        rabbitTemplate.convertAndSend(directExchangeName, orderConfirmationRoutingKey, orderConfirmation);
    }
}
