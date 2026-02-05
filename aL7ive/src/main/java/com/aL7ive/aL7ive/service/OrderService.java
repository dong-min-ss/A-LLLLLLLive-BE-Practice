package com.aL7ive.aL7ive.service;

import com.aL7ive.aL7ive.dto.OrderRequest;
import com.aL7ive.aL7ive.entity.Order;
import com.aL7ive.aL7ive.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Long saveOrder(OrderRequest request) {
        Order order = Order.builder()
                .productId(request.getProductId())
                .username(request.getUsername())
                .deliveryTimeSlot(request.getDeliveryTimeSlot())
                .totalPrice(request.getTotalPrice())
                .status("SUCCESS_ORDER")
                .build();

        return orderRepository.save(order).getId();
    }
}