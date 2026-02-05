package com.aL7ive.aL7ive.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders")
@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int productId;
    private String username;
    private String deliveryTimeSlot;
    private int totalPrice;
    private String status;
}