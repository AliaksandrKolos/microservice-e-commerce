package com.kolos.paymentservice.data.repository;

import com.kolos.paymentservice.data.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
