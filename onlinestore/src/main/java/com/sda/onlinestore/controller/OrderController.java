package com.sda.onlinestore.controller;

import com.sda.onlinestore.dto.OrderDto;
import com.sda.onlinestore.model.OrderModel;
import com.sda.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getOrders")
    public List<OrderDto> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/getOrderById/{id}")
    public OrderDto getOrder(@PathVariable(name = "id") Long idOrder){
        return orderService.findById(idOrder);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public void deleteOrder(@PathVariable(name = "id") Long idOrder){
        orderService.removeOrder(idOrder);
    }

    @GetMapping("/orders/getByUsername/{username}")
    public OrderDto getByUsername(@PathVariable(name = "username") String username){
       return orderService.findByUserName(username);
    }

    @GetMapping("/orders/deleteOrderLineById/{username}/idOrderLine")
    public OrderDto deleteOrderLineById(@PathVariable(name = "username") String username, @PathVariable(name = "idOrderLine")Long idOrderLine){
        return orderService.deleteOrderLineById(username, idOrderLine);
    }

    @PostMapping("/addOrder/{username}/{idProduct}")
    public void addOrder(@PathVariable(name = "username")String username,@PathVariable(name = "idProduct") Long idProduct){
        orderService.addToCart(username, idProduct);
    }

    @PutMapping("/updateOrder")
    public void updateOrder(@RequestBody OrderDto orderDto){
        orderService.updateCart(orderDto);
    }
}
