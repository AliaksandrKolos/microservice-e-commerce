package com.kolos.orderservice.service;

import com.kolos.orderservice.service.dto.OrderRequest;
import com.kolos.orderservice.service.dto.OrderResponse;

import java.util.List;

public interface OrderService {

    Integer createOrder(OrderRequest request);

    List<OrderResponse> findAll();

    OrderResponse findById(Integer orderId);
}
