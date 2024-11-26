package com.kolos.orderservice.service;

import com.kolos.orderservice.data.entity.Order;
import com.kolos.orderservice.service.dto.OrderRequest;
import com.kolos.orderservice.service.dto.OrderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toOrder(OrderRequest request);

    OrderResponse fromOrder(Order order);
}
