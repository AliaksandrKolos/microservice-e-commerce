package com.kolos.orderservice.data.repository;

import com.kolos.orderservice.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
