package com.kolos.orderservice.service.impl;

import com.kolos.orderservice.data.repository.OrderRepository;
import com.kolos.orderservice.service.MessagePublisher;
import com.kolos.orderservice.service.OrderLineService;
import com.kolos.orderservice.service.OrderMapper;
import com.kolos.orderservice.service.OrderService;
import com.kolos.orderservice.service.dto.OrderConfirmation;
import com.kolos.orderservice.service.dto.OrderLineRequest;
import com.kolos.orderservice.service.dto.OrderRequest;
import com.kolos.orderservice.service.dto.OrderResponse;
import com.kolos.orderservice.service.dto.PurchaseRequest;
import com.kolos.orderservice.web.client.customer.CustomerClient;
import com.kolos.orderservice.web.client.customer.ProductClient;
import com.kolos.orderservice.web.client.payment.PaymentClient;
import com.kolos.orderservice.web.client.payment.PaymentRequest;
import com.kolos.orderservice.web.exception.BusinessException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderLineService orderLineService;
    private final MessagePublisher messagePublisher;
    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final PaymentClient paymentClient;
    private final ProductClient productClient;
    private final OrderMapper orderMapper;


    @Override
    public Integer createOrder(OrderRequest request) {
        var customer = this.customerClient.findCustomerById(request.getCustomerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with the provided ID"));
        var purchasedProducts = this.productClient.purchaseProducts(request.getProducts());
        var order = orderRepository.save(orderMapper.toOrder(request));
        for (PurchaseRequest purchaseRequest : request.getProducts()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.getProductId(),
                            purchaseRequest.getQuantity()
                    )
            );
        }
        var paymentRequest = new PaymentRequest(
                request.getAmount(),
                request.getPaymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);

        messagePublisher.sendOrderConfirmation(
                new OrderConfirmation(
                        request.getReference(),
                        request.getAmount(),
                        request.getPaymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getId();
    }

    @Override
    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::fromOrder)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse findById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No order found with the provided ID: %d ", orderId)));
    }


}
