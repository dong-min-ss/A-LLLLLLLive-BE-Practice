package com.aL7ive.aL7ive.controller;

import com.aL7ive.aL7ive.dto.OrderRequest;
import com.aL7ive.aL7ive.service.OrderService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oliveyoung/api")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/orders/complete")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest request) {
        try {
            Long orderId = orderService.saveOrder(request);
            return ResponseEntity.ok(Map.of(
                    "code", "SUCCESS_ORDER",
                    "message", "Success.",
                    "orderId", orderId
            ));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of(
                    "code", "ERROR",
                    "message", "주문 생성 실패"
            ));
        }
    }
}