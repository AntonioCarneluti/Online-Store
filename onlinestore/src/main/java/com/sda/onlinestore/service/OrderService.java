package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.OrderDto;
import com.sda.onlinestore.dto.OrderLineDto;
import com.sda.onlinestore.model.OrderLineModel;
import com.sda.onlinestore.model.OrderModel;
import com.sda.onlinestore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public void addOrder(OrderDto orderDto){
        OrderModel orderModel = new OrderModel();
        orderModel.setId(orderDto.getId());
        orderModel.setTotalCost(orderDto.getTotalCost());
        List<OrderLineDto> orderLineDto = orderDto.getOrderLineDtoModels();
        List<OrderLineModel> orderLineModels = new ArrayList<>();
        for(OrderLineDto orderLineDto1: orderLineDto){

        }

        //orderModel.setOrderLineModels(orderDto.getOrderLineDtoModels());
    }
}
