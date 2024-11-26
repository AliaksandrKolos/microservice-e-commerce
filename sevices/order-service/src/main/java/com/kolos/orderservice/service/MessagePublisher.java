package com.kolos.orderservice.service;

import com.kolos.orderservice.service.dto.OrderConfirmation;

public interface MessagePublisher {

    void sendOrderConfirmation(OrderConfirmation orderConfirmation);
}
