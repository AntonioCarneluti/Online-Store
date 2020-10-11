package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.OrderDto;
import com.sda.onlinestore.dto.OrderLineDto;
import com.sda.onlinestore.dto.ProductDto;
import com.sda.onlinestore.model.OrderLineModel;
import com.sda.onlinestore.model.OrderModel;
import com.sda.onlinestore.model.ProductModel;
import com.sda.onlinestore.repository.OrderRepository;
import com.sda.onlinestore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;



    public List<OrderDto> getOrders(){
        List<OrderModel> orderModels = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();

        for (OrderModel orderModel: orderModels){
            OrderDto orderDto = new OrderDto();
            orderDto.setId(orderModel.getId());
            orderDto.setTotalCost(orderModel.getTotalCost());

            List<OrderLineModel> orderLineModels = orderModel.getOrderLineModels();
            List<OrderLineDto> orderLineDtoList = new ArrayList<>();

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
                orderLineDtoList.add(orderLineDto);
            }
            orderDto.setOrderLineDtoModels(orderLineDtoList);
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

            List<OrderLineModel> orderLineModels = foundOrderModel.getOrderLineModels();
            List<OrderLineDto> orderLineDtoList = new ArrayList<>();

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
                orderLineDtoList.add(orderLineDto);
            }
            orderDto.setOrderLineDtoModels(orderLineDtoList);





            return  orderDto;
        }
        return  null;
    }

    public void removeOrder (Long id){
        orderRepository.deleteById(id);
    }

    public OrderDto findByUserName(String username){
        OrderModel orderModel = orderRepository.findByUserName(username);
        OrderDto orderDto = new OrderDto();
        orderDto.setId(orderModel.getId());

        List<OrderLineModel> orderLineModels = orderModel.getOrderLineModels();
        List<OrderLineDto> orderLineDtoList = new ArrayList<>();

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
            orderLineDtoList.add(orderLineDto);
        }
        orderDto.setOrderLineDtoModels(orderLineDtoList);

        return orderDto;
    }

    public void addToCart(String username, Long id){
        OrderModel orderModel = orderRepository.findByUserName(username);
        Optional<ProductModel> productModel = productRepository.findById(id);
        List<OrderLineModel> orderLineModelList =  orderModel.getOrderLineModels();

        if(productModel.isPresent()){
            ProductModel foundProductModel = productModel.get();
            for( OrderLineModel orderLineModel1:orderLineModelList ){
                if(orderLineModel1.getProductModel().getId().equals(id)){
                    orderLineModel1.setQuantity(orderLineModel1.getQuantity() + 1);
                    orderLineModel1.setPrice(orderLineModel1.getQuantity()* orderLineModel1.getProductModel().getPrice());
                }else{
                    orderLineModel1.setProductModel(foundProductModel);
                    orderLineModel1.setQuantity(1);
                    orderLineModel1.setPrice(orderLineModel1.getQuantity()* orderLineModel1.getProductModel().getPrice());
                }
                orderModel.setOrderLineModels(orderLineModelList);
            }
        }
        orderRepository.save(orderModel);
    }
}
