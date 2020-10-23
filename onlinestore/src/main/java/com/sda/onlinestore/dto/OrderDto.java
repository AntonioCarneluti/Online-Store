package com.sda.onlinestore.dto;

import com.sda.onlinestore.model.OrderLineModel;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OrderDto {

    private Long id;

    private double totalCost;


    private List<OrderLineDto> orderLineDtoModels = new ArrayList<>();

    private String status;




    public Long getId() {
        return id;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }



    public List<OrderLineDto> getOrderLineDtoModels() {
        return orderLineDtoModels;
    }

    public void setOrderLineDtoModels(List<OrderLineDto> orderLineDtoModels) {
        this.orderLineDtoModels = orderLineDtoModels;
    }
}
