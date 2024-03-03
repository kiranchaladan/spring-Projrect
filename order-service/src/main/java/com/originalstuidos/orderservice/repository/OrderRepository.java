package com.originalstuidos.orderservice.repository;

import com.originalstuidos.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
