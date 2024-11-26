package com.kolos.orderservice.service;

import com.kolos.orderservice.service.dto.OrderLineRequest;
import com.kolos.orderservice.service.dto.OrderLineResponse;

import java.util.List;

public interface OrderLineService {

    Integer saveOrderLine(OrderLineRequest orderLineRequest);

    List<OrderLineResponse> findAllByOrderId(Integer orderId);
}
