package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.OrderDto;
import com.sda.onlinestore.dto.OrderLineDto;
import com.sda.onlinestore.dto.ProductDto;
import com.sda.onlinestore.model.OrderLineModel;
import com.sda.onlinestore.model.OrderModel;
import com.sda.onlinestore.model.ProductModel;
import com.sda.onlinestore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    /*public void addOrder(OrderDto orderDto){
        OrderModel orderModel = new OrderModel();
        orderModel.setTotalCost(orderDto.getTotalCost());

        }*/

        //orderModel.setOrderLineModels(orderDto.getOrderLineDtoModels());


    private List<OrderDto> getOrders(){
        List<OrderModel> orderModels = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();

        for (OrderModel orderModel: orderModels){
            OrderDto orderDto = new OrderDto();
            orderDto.setId(orderModel.getId());
            orderDto.setTotalCost(orderModel.getTotalCost());

            List<OrderLineModel> orderLineModels = orderModel.getOrderLineModels();
            List<OrderDto> orderDtos1 = new ArrayList<>();

            for(OrderLineModel orderLineModel: orderLineModels){
                OrderLineDto orderLineDto = new OrderLineDto();
                orderLineDto.setId((orderLineModel.getId()));
                orderLineDto.setPrice(orderLineModel.getPrice());
                orderLineDto.setQuantity(orderLineModel.getQuantity());

                ProductModel productModel = orderLineModel.getProductModel();
                ProductDto productDto = new ProductDto();

                productDto.setId(productModel.getId());
                productDto.setPrice(productModel.getPrice());
                productDto.setName(productModel.getName());

                orderLineDto.setProductDto(productDto);
                orderDtos1.add(orderDto);
            }

            orderDtos.add(orderDto);
        }

        return orderDtos;
    }

    public OrderDto findById(Long id){
        Optional<OrderModel> orderModel = orderRepository.findById(id);
        OrderDto orderDto = new OrderDto();
        if(orderModel.isPresent()){
            OrderModel foundOrderModel = orderModel.get();
            orderDto.setId(foundOrderModel.getId());
            orderDto.setTotalCost(foundOrderModel.getTotalCost());

            return  orderDto;
        }
        return  null;
    }

    
}
