package com.example.XYZ.repository;

import com.example.XYZ.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOrderByOrderId(Long id);
}
