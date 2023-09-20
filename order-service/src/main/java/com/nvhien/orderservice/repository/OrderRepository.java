package com.nvhien.orderservice.repository;

import com.nvhien.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    boolean existsByOrderNumber(String orderNumber);
}
