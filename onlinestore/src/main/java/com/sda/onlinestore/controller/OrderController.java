package com.sda.onlinestore.controller;

import com.sda.onlinestore.dto.OrderDto;
import com.sda.onlinestore.model.OrderModel;
import com.sda.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<OrderDto> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/order/{id}")
    public OrderDto getOrder(@PathVariable(name = "id") Long idOrder){
        return orderService.findById(idOrder);
    }

    @DeleteMapping("/order/{id}")
    public void deleteOrder(@PathVariable(name = "id") Long idOrder){
        orderService.removeOrder(idOrder);
    }

    @GetMapping("/orders/getbyusername/{username}")
    public OrderDto getByUsername(@PathVariable(name = "username") String username){
       return orderService.findByUserName(username);
    }

   /* @PostMapping("/orders")
    public void addOrder(@RequestBody OrderModel orderModel){
        orderService.addToCart();
    }*/
}
