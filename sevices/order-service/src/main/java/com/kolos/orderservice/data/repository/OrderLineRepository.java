package com.kolos.orderservice.data.repository;

import com.kolos.orderservice.data.entity.OrderLine;
import com.kolos.orderservice.service.dto.OrderLineResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {

    List<OrderLine> findBiOrderId(Integer orderId);
}
