package com.sda.onlinestore.repository;


import com.sda.onlinestore.model.OrderModel;
import com.sda.onlinestore.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {

    Optional<OrderModel> findByUserName(String username);
    Optional<OrderModel> findByUserNameAndStatus(String username, Status status);
}
