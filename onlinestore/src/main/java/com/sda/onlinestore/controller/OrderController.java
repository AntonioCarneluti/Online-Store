package com.sda.onlinestore.controller;

import com.sda.onlinestore.dto.OrderDto;
import com.sda.onlinestore.model.OrderModel;
import com.sda.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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

    @GetMapping("/orders/getByUsername")
    public OrderDto getByUsername(){
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       return orderService.findByUserName(username);
    }

    /*@GetMapping("/orders/deleteOrderLineById/{username}/idOrderLine")
    public OrderDto deleteOrderLineById(@PathVariable(name = "username") String username, @PathVariable(name = "idOrderLine")Long idOrderLine){
        return orderService.deleteOrderLineById(username, idOrderLine);
    }*/

   // @GetMapping("/addOrder/{username}/{idProduct}")
   // public void addOrder(@PathVariable(name = "username")String username,@PathVariable(name = "idProduct") Long idProduct){
   @GetMapping("/addOrder/{idProduct}")
   public void addOrder(@PathVariable(name = "idProduct") Long idProduct){
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        orderService.addToCart(username, idProduct);
        //(SecurityProperties.User)
    }

    @PutMapping("/updateOrder/{idOrderLine}/{newQuantity}")
    public void updateOrder(@PathVariable(name = "idOrderLine") Long idOrderLine,
                            @PathVariable(name = "newQuantity") int newQuantity){
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
          orderService.updateCart(username, idOrderLine, newQuantity);
    }

    /*@GetMapping("/updateOrder/{username}/{idOrderLine}")
    public void updateOrderLineFromOrder(@PathVariable(name = "username") String username,
                                         @PathVariable(name = "idOrderLine") Long idOrderLine){
        orderService.deleteOrderLine(username, idOrderLine);
    }*/

    @GetMapping("/placeOrder/{orderId}")
    public OrderDto placeOrder(@PathVariable(name = "orderId") Long orderId){
        return orderService.placeOrder(orderId);
    }
}
