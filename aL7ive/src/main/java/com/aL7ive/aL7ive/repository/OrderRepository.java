package com.aL7ive.aL7ive.repository;

import com.aL7ive.aL7ive.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}