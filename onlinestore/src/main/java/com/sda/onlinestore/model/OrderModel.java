package com.sda.onlinestore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private double totalCost;

    private Date dateOfOrder;

    @Enumerated(EnumType.STRING)
    private  Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderModel", orphanRemoval = false )
    @JsonIgnoreProperties("orderModel")
    private List<OrderLineModel> orderLineModels = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public List<OrderLineModel> getOrderLineModels() {
        return orderLineModels;
    }

    public void setOrderLineModels(List<OrderLineModel> orderLineModels) {
        this.orderLineModels = orderLineModels;
    }
}
