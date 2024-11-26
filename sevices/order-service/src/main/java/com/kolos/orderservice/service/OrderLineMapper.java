package com.kolos.orderservice.service;

import com.kolos.orderservice.data.entity.Order;
import com.kolos.orderservice.data.entity.OrderLine;
import com.kolos.orderservice.service.dto.OrderLineRequest;
import com.kolos.orderservice.service.dto.OrderLineResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderLineMapper {

    @Mapping(target = "order", source = "orderId") // Связываем order с orderId
    OrderLine toOrderLine(OrderLineRequest request);

    default Order mapOrderIdToOrder(Integer orderId) {
        if (orderId == null) {
            return null;
        }
        return Order.builder().id(orderId).build();
    }

    OrderLineResponse toOrderLineResponse(OrderLine orderLine);
}
