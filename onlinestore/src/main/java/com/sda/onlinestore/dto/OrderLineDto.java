package com.sda.onlinestore.dto;

import com.sda.onlinestore.model.OrderLineModel;
import com.sda.onlinestore.model.ProductModel;

public class OrderLineDto {

    private Long id;

    private int quantity;

    private double price;

    private ProductDto productDto;

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
