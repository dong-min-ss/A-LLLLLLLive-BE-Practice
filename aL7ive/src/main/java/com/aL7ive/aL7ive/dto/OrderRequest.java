package com.aL7ive.aL7ive.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderRequest {
    private int productId;
    private int quantity;
    private boolean isTodayDelivery;
    private int totalPrice;
    private String username;
    private String phone;
    private String deliveryTimeSlot;
}