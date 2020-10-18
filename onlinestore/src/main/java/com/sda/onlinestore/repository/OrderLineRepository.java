package com.sda.onlinestore.repository;

import com.sda.onlinestore.model.OrderLineModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLineModel, Long> {
}
